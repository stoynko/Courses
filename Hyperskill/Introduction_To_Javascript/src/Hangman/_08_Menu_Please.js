/* Description
In this stage, let's add a little more flavor to the game by constructing a menu to restart the program after the current session ends.

Objectives:
  To complete this stage, follow the suggested order of the required checks:
    • The game now starts with the menu where players can choose to either play, see their score, or exit;
    • Print Type "play" to play the game, "results" to show the scoreboard, and "exit" to quit: and show this message again if players input something else;
    • If players choose play, start the game. When the game is finished (regardless of whether a player wins or not), pop up the menu once again to make the gameplay seamless;
    • If players choose results, print how many games they won, e.g. You won: 0 times., and how many games they lost, e.g. You lost: 25 times.;
    • If players choose exit, end the game. */

const input = require('sync-input');
let wins = 0;
let losses = 0;

initGame();

function initGame() {
    console.log('H A N G M A N');
    console.log('Type "play" to play the game, "results" to show the scoreboard, and "exit" to quit:');
    let userInput = input();
    while (userInput !== 'play' && userInput !== 'results' && userInput !== 'exit') {
        userInput = input();
    }

    switch (userInput) {
        case 'play':
            initGameLogic();
            break;
        case 'results':
            displayResults();
            break;
        case 'exit':
            return;

    }
}

function initGameLogic() {
    let userLives = 8;
    const word = getRandomWord();
    let hiddenWord = '-'.repeat(word.length);
    console.log('');
    console.log(hiddenWord);

    while (userLives > 0) {
        let guess = getUserInput();
        if (hiddenWord.includes(guess)) {
            console.log('No improvements.');
            console.log()
            userLives--;
        } else {
            let wordIndexes = getLetterIndexes(guess, word);
            if (wordIndexes.length === 0) {
                console.log("That letter doesn't appear in the word.");
                console.log('');
                userLives--;
            } else {
                for (const idx of wordIndexes) {
                    hiddenWord = revealLetter(word, hiddenWord, idx);
                }
            }
        }
        console.log(hiddenWord);
        if (!hiddenWord.includes('-')) {
            wins += 1;
            console.log(`You guessed the word ${word}!`);
            console.log('You survived!');
            break;
        }

        if (userLives === 0) {
            losses += 1;
            console.log('You lost!');
        }
    }
    initGame();
}

function displayResults() {
    console.log(`You won: ${wins} times.`)
    console.log(`You lost: ${losses} times.`)
    initGame();
}

function getUserInput() {
    console.log('Input a letter:');
    let userInput = input();

    while (!isInputValid(userInput)) {
        userInput = getUserInput();
    }

    return userInput;
}

function isInputValid(userInput) {
    if (userInput.length === 0 || userInput.length > 1) {
        console.log('Please, input a single letter.');
        return false;
    }
    let ascii = userInput.charCodeAt(0);

    if (ascii < 97 || ascii > 122) {
        console.log('Please, enter a lowercase letter from the English alphabet.');
        return false;
    }

    return true;
}

function getRandomWord() {
    const wordsRepo = ['python', 'java', 'swift', 'javascript'];
    let randomNumber = Math.floor(Math.random() * wordsRepo.length);
    return wordsRepo[randomNumber]
}

function getLetterIndexes(guess, word) {
    let currentIndex = 0;
    let letterIndexes = [];

    while (true) {
        currentIndex = word.indexOf(guess, currentIndex);

        if (currentIndex === -1) {
            break;
        }

        letterIndexes.push(currentIndex);
        currentIndex++;
    }

    return letterIndexes;
}

function revealLetter(word, hiddenWord, wordIndex) {
    let wordChars = hiddenWord.split('');
    wordChars[wordIndex] = word[wordIndex];
    return wordChars.join('');
}