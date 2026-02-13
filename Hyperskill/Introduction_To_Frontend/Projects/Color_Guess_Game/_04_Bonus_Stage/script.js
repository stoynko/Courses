let correctColor = generateRandomColor();
let colorBlocks = document.getElementsByClassName("color-block");

document.getElementById("restart").addEventListener("click", restartGame);

displayColorToGuess();
randomizeColorBlocks();

for (let i = 0; i < colorBlocks.length; i++) {
    colorBlocks[i].addEventListener("click", compareColors);
}

function compareColors() {
    let status = document.getElementById("status");
    if (this.style.backgroundColor === correctColor) {
        status.textContent = "Correct!";
        displayCorrectColor(colorBlocks);
    } else {
        status.textContent = "Try Again!";
        this.style.display = "none";
    }
}

function displayColorToGuess() {
    let colorToGuess = document.getElementById("rgb-color");
    colorToGuess.textContent = correctColor.toUpperCase();
}

function displayCorrectColor(colorBlocks) {
    for (let i = 0; i < colorBlocks.length; i++) {
        colorBlocks[i].style.display = "inline-block";
        colorBlocks[i].style.backgroundColor = correctColor;
    }
}

function generateRandomColor() {
    let red = Math.floor(Math.random() * 255);
    let green = Math.floor(Math.random() * 255);
    let blue = Math.floor(Math.random() * 255);
    return "rgb" + "(" + red + ", " + green + ", " + blue + ")";
}

function randomizeColorBlocks() {
    let colorBlocks = document.getElementsByClassName("color-block");
    let randomIndex = Math.floor(Math.random() * colorBlocks.length);

    for (let i = 0; i < colorBlocks.length; i++) {
        if (i === randomIndex) {
            colorBlocks[i].style.backgroundColor = correctColor;
            continue;
        }
        let colorBlock = colorBlocks[i];
        let randomColor = generateRandomColor();

        if (randomColor === correctColor) {
            i--;
            continue;
        }
        colorBlock.style.backgroundColor = generateRandomColor();
    }
}

function restartGame() {
    correctColor = generateRandomColor();
    displayColorToGuess();
    let colorBlocks = document.getElementsByClassName("color-block");
    for (let block of colorBlocks) {
        block.style.display = "";
    }
    randomizeColorBlocks();
    document.getElementById("status").textContent = "Start Guessing!";
}