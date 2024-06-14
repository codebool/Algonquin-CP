const standardAnswers = {
    1: `function sum(a, b) { return a + b; }`,
    2: `function max(arr) { return Math.max(...arr); }`,
    3: `function reverseString(str) { return str.split('').reverse().join(''); }`,
    4: `function isEven(num) { return num % 2 === 0; }`,
    5: `function factorial(n) { return n ? n * factorial(n - 1) : 1; }`
};

const explanations = {
    1: "The correct way to declare a variable in JavaScript is using 'let' or 'const'. 'var' is also correct but not preferred due to scoping issues.",
    2: "Arrays in JavaScript are declared using square brackets [].",
    3: "The 'onclick' event occurs when the user clicks on an HTML element.",
    4: "Comments in JavaScript can be single-line (//) or multi-line (/* */).",
    5: "The correct way to declare a variable in JavaScript is using 'var', 'let', or 'const'.",
    6: "A function in JavaScript is created using the 'function' keyword followed by the function name and parentheses.",
    7: "A function in JavaScript is called by using its name followed by parentheses.",
    8: "An IF statement in JavaScript is written as 'if (condition) { ... }'.",
    9: "A WHILE loop in JavaScript starts with 'while (condition) { ... }'.",
    10: "Single-line comments in JavaScript start with //."
};

function checkMCQ() {
    const answers = {
        q1: 'c',
        q2: 'b',
        q3: 'd',
        q4: 'b',
        q5: 'b',
        q6: 'a',
        q7: 'b',
        q8: 'c',
        q9: 'c',
        q10: 'b'
    };

    let score = 0;
    let total = 10;

    for (let question in answers) {
        const selected = document.querySelector(`input[name="${question}"]:checked`);
        if (selected && selected.value === answers[question]) {
            score++;
        }
    }

    alert(`You scored ${score} out of ${total}`);
    revealExplanations();
}

function runCodeQuestion(questionNumber) {
    const code = document.getElementById(`code${questionNumber}`).value;
    const outputElement = document.getElementById(`output${questionNumber}`);
    const resultElement = document.getElementById(`output${questionNumber}-result`);
    outputElement.innerText = '';
    resultElement.innerText = '';
    try {
        const userFunction = new Function(`return (${code.trim()})`)();
        const standardFunction = new Function(`return (${standardAnswers[questionNumber]})`)();
        const result = userFunction(...getArguments(questionNumber));
        const expectedResult = standardFunction(...getArguments(questionNumber));
        const resultMatch = JSON.stringify(result).trim() === JSON.stringify(expectedResult).trim();
        const codeMatchPercentage = calculateCodeMatchPercentage(code, standardAnswers[questionNumber]);

        outputElement.innerText = result !== undefined ? result : 'Code executed successfully.';
        if (resultMatch) {
            resultElement.innerText = 'Correct result!';
        } else {
            resultElement.innerText = `Incorrect result. Expected: ${expectedResult}, Got: ${result}`;
        }
        resultElement.innerText += ` Code match: ${codeMatchPercentage.toFixed(2)}%`;
        if (codeMatchPercentage >= 75 && resultMatch) {
            resultElement.innerText += ' Function works correctly.';
        } else {
            resultElement.innerText += ' Function does not work correctly.';
        }
    } catch (error) {
        outputElement.innerText = `Error: ${error.message}`;
    }
}

function getArguments(questionNumber) {
    switch (questionNumber) {
        case 1: return [2, 3];
        case 2: return [[1, 2, 3]];
        case 3: return ["hello"];
        case 4: return [4];
        case 5: return [5];
        default: return [];
    }
}

function calculateCodeMatchPercentage(userCode, standardCode) {
    const userTokens = tokenizeCode(userCode);
    const standardTokens = tokenizeCode(standardCode);

    const totalTokens = Math.max(userTokens.length, standardTokens.length);
    const matchingTokens = userTokens.filter(token => standardTokens.includes(token)).length;

    return (matchingTokens / totalTokens) * 100;
}

function tokenizeCode(code) {
    return code.replace(/\s+/g, '').split(/([{}()[\];,])/).filter(Boolean);
}

function compareFunctions(userCode, standardCode) {
    return calculateCodeMatchPercentage(userCode, standardCode) >= 75;
}

function checkCodingQuestions() {
    let correctCount = 0;
    const totalQuestions = 5;

    for (let i = 1; i <= totalQuestions; i++) {
        const resultElement = document.getElementById(`output${i}-result`);
        if (resultElement.innerText.includes('Function works correctly.')) {
            correctCount++;
        }
    }

    alert(`You got ${correctCount} out of ${totalQuestions} correct.`);
    revealExplanations();
}

function revealExplanations() {
    for (let i = 1; i <= 10; i++) {
        const explanationElement = document.getElementById(`explanation${i}`);
        explanationElement.style.display = 'block';
    }
}
