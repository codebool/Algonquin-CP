function checkQuiz() {
    let score = 0;

    const q1 = document.querySelector('input[name="q1"]:checked');
    const q2 = document.querySelector('input[name="q2"]:checked');
    const q3 = document.querySelector('input[name="q3"]:checked');
    const q4 = document.querySelector('input[name="q4"]:checked');

    if (q1 && q1.value === 'a') score++;
    if (q2 && q2.value === 'b') score++;
    if (q3 && q3.value === 'b') score++;
    if (q4 && q4.value === 'c') score++;

    document.getElementById('result').textContent = `You scored ${score} out of 4`;
}

function resetForms() {
    document.getElementById('result').textContent = '';

    // const forms = document.querySelectorAll('form');
    // forms.forEach(form => form.reset());

    // Array.from(document.getElementsByTagName('form')).forEach(form => form.reset());

    const forms = [...document.getElementsByTagName('form')];
    forms.forEach(form => form.reset());
}