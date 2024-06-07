const canvas = document.getElementById('gameCanvas');
const context = canvas.getContext('2d');
const gridSize = 20;
const rows = canvas.height / gridSize;
const cols = canvas.width / gridSize;

let pacman = { x: 1, y: 1, dir: 'RIGHT' };
let ghosts = [
    { x: cols - 2, y: rows - 2, dir: 'LEFT' },
    { x: 1, y: rows - 2, dir: 'RIGHT' },
    { x: cols - 2, y: 1, dir: 'DOWN' }
];
let bullets = [];
let maze = [];
let score = 0;
let ghostSpawnInterval;
let bulletFireCooldown = false;

function createMaze() {
    for (let row = 0; row < rows; row++) {
        maze[row] = [];
        for (let col = 0; col < cols; col++) {
            if (row === 0 || row === rows - 1 || col === 0 || col === cols - 1) {
                maze[row][col] = 1;
            } else if (Math.random() > 0.7) {
                maze[row][col] = 1;
            } else {
                maze[row][col] = 0;
            }
        }
    }
    maze[1][1] = 0; // Pac-Man's starting position
    ghosts.forEach(ghost => {
        maze[ghost.y][ghost.x] = 0; // Ghosts' starting positions
    });
}

function drawMaze() {
    context.clearRect(0, 0, canvas.width, canvas.height);
    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            if (maze[row][col] === 1) {
                context.fillStyle = '#000';
                context.fillRect(col * gridSize, row * gridSize, gridSize, gridSize);
            }
        }
    }
}

function drawPacman() {
    context.fillStyle = 'yellow';
    context.beginPath();
    const centerX = pacman.x * gridSize + gridSize / 2;
    const centerY = pacman.y * gridSize + gridSize / 2;
    if (pacman.dir === 'UP') {
        context.moveTo(centerX, centerY);
        context.lineTo(centerX - gridSize / 2, centerY + gridSize / 2);
        context.lineTo(centerX + gridSize / 2, centerY + gridSize / 2);
    } else if (pacman.dir === 'DOWN') {
        context.moveTo(centerX, centerY);
        context.lineTo(centerX - gridSize / 2, centerY - gridSize / 2);
        context.lineTo(centerX + gridSize / 2, centerY - gridSize / 2);
    } else if (pacman.dir === 'LEFT') {
        context.moveTo(centerX, centerY);
        context.lineTo(centerX + gridSize / 2, centerY - gridSize / 2);
        context.lineTo(centerX + gridSize / 2, centerY + gridSize / 2);
    } else if (pacman.dir === 'RIGHT') {
        context.moveTo(centerX, centerY);
        context.lineTo(centerX - gridSize / 2, centerY - gridSize / 2);
        context.lineTo(centerX - gridSize / 2, centerY + gridSize / 2);
    }
    context.closePath();
    context.fill();
}

function drawGhosts() {
    context.fillStyle = 'red';
    ghosts.forEach(ghost => {
        context.fillRect(ghost.x * gridSize, ghost.y * gridSize, gridSize, gridSize);
    });
}

function drawBullets() {
    context.fillStyle = 'blue';
    bullets.forEach(bullet => {
        context.fillRect(bullet.x * gridSize + gridSize / 4, bullet.y * gridSize + gridSize / 4, gridSize / 2, gridSize / 2);
    });
}

function movePacman() {
    if (pacman.dir === 'UP' && maze[pacman.y - 1][pacman.x] === 0) {
        pacman.y -= 1;
    } else if (pacman.dir === 'DOWN' && maze[pacman.y + 1][pacman.x] === 0) {
        pacman.y += 1;
    } else if (pacman.dir === 'LEFT' && maze[pacman.y][pacman.x - 1] === 0) {
        pacman.x -= 1;
    } else if (pacman.dir === 'RIGHT' && maze[pacman.y][pacman.x + 1] === 0) {
        pacman.x += 1;
    }
}

function moveGhosts() {
    ghosts.forEach(ghost => {
        const direction = getDirectionToChase(pacman, ghost);

        if (direction === 'UP' && maze[ghost.y - 1][ghost.x] === 0) {
            ghost.y -= 1;
        } else if (direction === 'DOWN' && maze[ghost.y + 1][ghost.x] === 0) {
            ghost.y += 1;
        } else if (direction === 'LEFT' && maze[ghost.y][ghost.x - 1] === 0) {
            ghost.x -= 1;
        } else if (direction === 'RIGHT' && maze[ghost.y][ghost.x + 1] === 0) {
            ghost.x += 1;
        }
    });
}

function moveBullets() {
    bullets.forEach((bullet, index) => {
        if (bullet.dir === 'UP') bullet.y -= 1;
        if (bullet.dir === 'DOWN') bullet.y += 1;
        if (bullet.dir === 'LEFT') bullet.x -= 1;
        if (bullet.dir === 'RIGHT') bullet.x += 1;

        // Remove bullet if it goes out of bounds or hits a wall
        if (bullet.x < 0 || bullet.x >= cols || bullet.y < 0 || bullet.y >= rows || maze[bullet.y][bullet.x] === 1) {
            bullets.splice(index, 1);
        }
    });
}

function fireBullet() {
    if (!bulletFireCooldown) {
        bullets.push({ x: pacman.x, y: pacman.y, dir: pacman.dir });
        bullets.push({ x: pacman.x, y: pacman.y, dir: pacman.dir });
        bullets.push({ x: pacman.x, y: pacman.y, dir: pacman.dir });
        bulletFireCooldown = true;
        setTimeout(() => bulletFireCooldown = false, 500);
    }
}

function getDirectionToChase(target, chaser) {
    const directions = [];
    if (target.y < chaser.y) directions.push('UP');
    if (target.y > chaser.y) directions.push('DOWN');
    if (target.x < chaser.x) directions.push('LEFT');
    if (target.x > chaser.x) directions.push('RIGHT');
    return directions[Math.floor(Math.random() * directions.length)];
}

function checkCollision() {
    ghosts.forEach((ghost, ghostIndex) => {
        bullets.forEach((bullet, bulletIndex) => {
            if (ghost.x === bullet.x && ghost.y === bullet.y) {
                score += 1;
                document.getElementById('score').innerText = `Score: ${score}`;
                ghosts.splice(ghostIndex, 1);
                bullets.splice(bulletIndex, 1);
            }
        });
        
        if (pacman.x === ghost.x && pacman.y === ghost.y) {
            resetGame();
        }
    });
}

function spawnGhost() {
    const ghost = {
        x: Math.floor(Math.random() * (cols - 2)) + 1,
        y: Math.floor(Math.random() * (rows - 2)) + 1,
        dir: 'LEFT'
    };
    ghosts.push(ghost);
}

function resetGame() {
    pacman = { x: 1, y: 1, dir: 'RIGHT' };
    ghosts = [
        { x: cols - 2, y: rows - 2, dir: 'LEFT' },
        { x: 1, y: rows - 2, dir: 'RIGHT' },
        { x: cols - 2, y: 1, dir: 'DOWN' }
    ];
    bullets = [];
    score = 0;
    document.getElementById('score').innerText = `Score: ${score}`;
    createMaze();
}

document.addEventListener('keydown', event => {
    switch (event.keyCode) {
        case 37: // left arrow
            pacman.dir = 'LEFT';
            break;
        case 38: // up arrow
            pacman.dir = 'UP';
            break;
        case 39: // right arrow
            pacman.dir = 'RIGHT';
            break;
        case 40: // down arrow
            pacman.dir = 'DOWN';
            break;
        case 32: // space bar
            fireBullet();
            break;
    }
});

function gameLoop() {
    movePacman();
    moveGhosts();
    moveBullets();
    checkCollision();
    drawMaze();
    drawPacman();
    drawGhosts();
    drawBullets();
    setTimeout(gameLoop, 200);
}

createMaze();
ghostSpawnInterval = setInterval(spawnGhost, 60000);
gameLoop();
