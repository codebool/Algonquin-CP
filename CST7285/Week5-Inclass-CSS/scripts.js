document.addEventListener('DOMContentLoaded', function () {
    const accordions = document.querySelectorAll('.accordion');
    accordions.forEach(accordion => {
        accordion.addEventListener('click', function () {
            this.classList.toggle('active');
            const panel = this.nextElementSibling;
            if (panel.style.display === 'block') {
                panel.style.display = 'none';
            } else {
                panel.style.display = 'block';
            }
        });
    });
});

function toggleCode(id) {
    const codeBlock = document.getElementById(id);
    if (codeBlock.style.display === 'none' || codeBlock.style.display === '') {
        codeBlock.style.display = 'block';
    } else {
        codeBlock.style.display = 'none';
    }
}

function checkQuiz() {
    let score = 0;

    const q1 = document.querySelector('input[name="q1"]:checked');
    const q2 = document.querySelector('input[name="q2"]:checked');
    const q3 = document.querySelector('input[name="q3"]:checked');

    if (q1 && q1.value === 'b') score++;
    if (q2 && q2.value === 'b') score++;
    if (q3 && q3.value === 'b') score++;

    document.getElementById('result').textContent = `You scored ${score} out of 3`;
}
