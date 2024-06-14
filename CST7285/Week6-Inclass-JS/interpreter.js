(function() {
    const originalConsoleLog = console.log;
    const outputElement = document.getElementById('output');

    console.log = function(message) {
        originalConsoleLog.apply(console, arguments);
        outputElement.innerText += message + '\n';
    };

    window.runCode = function() {
        const code = document.getElementById('code').value;
        outputElement.innerText = ''; // Clear previous output
        try {
            const result = eval(code);
            if (result !== undefined) {
                console.log(result);
            }
        } catch (error) {
            console.log('Error: ' + error.message);
        }
    };
})();
