const canvas = document.getElementById('gameCanvas');
const context = canvas.getContext('2d');
const grid = 30;
const rows = 20;
const cols = 10;
let score = 0;

const tetrominoes = [
    { shape: [[1, 1, 1], [0, 1, 0]], color: 'red' },
    { shape: [[1, 1], [1, 1]], color: 'blue' },
    { shape: [[1, 1, 0], [0, 1, 1]], color: 'green' },
    { shape: [[0, 1, 1], [1, 1, 0]], color: 'purple' },
    { shape: [[1, 1, 1, 1]], color: 'orange' },
    { shape: [[1, 1, 1], [1, 0, 0]], color: 'yellow' },
    { shape: [[1, 1, 1], [0, 0, 1]], color: 'cyan' }
];

const tetromino = {
    x: 0,
    y: 0,
    shape: [],
    color: ''
};

const playfield = [];

// Create empty playfield
for (let row = 0; row < rows; row++) {
    playfield[row] = [];
    for (let col = 0; col < cols; col++) {
        playfield[row][col] = 0;
    }
}

function drawBlock(x, y, color) {
    context.fillStyle = color;
    context.fillRect(x * grid, y * grid, grid - 1, grid - 1);
}

function drawPlayfield() {
    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            if (playfield[row][col]) {
                drawBlock(col, row, playfield[row][col]);
            }
        }
    }
}

function drawTetromino() {
    for (let row = 0; row < tetromino.shape.length; row++) {
        for (let col = 0; col < tetromino.shape[row].length; col++) {
            if (tetromino.shape[row][col]) {
                drawBlock(tetromino.x + col, tetromino.y + row, tetromino.color);
            }
        }
    }
}

function moveTetromino(deltaX, deltaY) {
    if (!collides(tetromino.x + deltaX, tetromino.y + deltaY, tetromino.shape)) {
        tetromino.x += deltaX;
        tetromino.y += deltaY;
    } else if (deltaY > 0) {
        placeTetromino();
        removeFullLines();
        resetTetromino();
        if (collides(tetromino.x, tetromino.y, tetromino.shape)) {
            resetGame();
        }
    }
}

function collides(x, y, shape) {
    for (let row = 0; row < shape.length; row++) {
        for (let col = 0; col < shape[row].length; col++) {
            if (shape[row][col] &&
                (playfield[y + row] && playfield[y + row][x + col]) !== 0) {
                return true;
            }
            if (shape[row][col] && (x + col < 0 || x + col >= cols || y + row >= rows)) {
                return true;
            }
        }
    }
    return false;
}

function placeTetromino() {
    for (let row = 0; row < tetromino.shape.length; row++) {
        for (let col = 0; col < tetromino.shape[row].length; col++) {
            if (tetromino.shape[row][col]) {
                playfield[tetromino.y + row][tetromino.x + col] = tetromino.color;
            }
        }
    }
}

function removeFullLines() {
    for (let row = playfield.length - 1; row >= 0; row--) {
        if (playfield[row].every(cell => cell !== 0)) {
            playfield.splice(row, 1);
            playfield.unshift(Array(cols).fill(0));
            score += 10;
            document.getElementById('score').innerText = `Score: ${score}`;
        }
    }
}

function resetTetromino() {
    const randomTetromino = tetrominoes[Math.floor(Math.random() * tetrominoes.length)];
    tetromino.shape = randomTetromino.shape;
    tetromino.color = randomTetromino.color;
    tetromino.x = Math.floor((cols - tetromino.shape[0].length) / 2);
    tetromino.y = 0;
}

function resetGame() {
    playfield.forEach(row => row.fill(0));
    score = 0;
    document.getElementById('score').innerText = `Score: ${score}`;
    resetTetromino();
}

document.addEventListener('keydown', event => {
    switch (event.keyCode) {
        case 37: // left arrow
            moveTetromino(-1, 0);
            break;
        case 39: // right arrow
            moveTetromino(1, 0);
            break;
        case 40: // down arrow
            moveTetromino(0, 1);
            break;
        case 38: // up arrow (rotate)
            const shape = rotate(tetromino.shape);
            if (!collides(tetromino.x, tetromino.y, shape)) {
                tetromino.shape = shape;
            }
            break;
    }
    draw();
});

function rotate(shape) {
    const newShape = shape[0].map((_, colIndex) =>
        shape.map(row => row[colIndex])
    ).reverse();
    return newShape;
}

function draw() {
    context.clearRect(0, 0, canvas.width, canvas.height);
    drawPlayfield();
    drawTetromino();
}

function gameLoop() {
    moveTetromino(0, 1);
    draw();
    setTimeout(gameLoop, 500);
}

resetTetromino();
gameLoop();
