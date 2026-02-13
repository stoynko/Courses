let correctColor = generateRandomColor();
displayColorToGuess();
randomizeColorBlocks();

function displayColorToGuess() {
    let colorToGuess = document.getElementById("rgb-color");
    colorToGuess.textContent = correctColor.toUpperCase();
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