/* Description
So far, our game has been some kind of a draft; we still lack a way to handle the player's victory.
The player has only eight attempts, and the number of remaining attempts decreases every turn, even if players guess them correctly.

In this stage, we will start reducing the attempts only after players make a mistake.
They can be mistaken eight times: attempts are reduced if the suggested letter is not in the word or if it has already been suggested before (no matter whether it's been a correct one or not).
If a player has guessed all the letters, they win. If a player has some attempts after guessing the word, discard them, notify the player, and terminate the game.

Objectives:
  Players start the game with eight lives. In other words, they can make a mistake only eight times.
    • When players input a valid letter, uncover it in the word, and carry on;
    • Print That letter doesn't appear in the word. and reduce the number of attempts if the word doesn't contain the letter,
      even if this particular letter has already been suggested before;
    • Print No improvements. and reduce the attempt counter when players input a letter that has been successfully uncovered before;
    • When players win, print the uncovered word, You guessed the word! , and the winning message. Each one should be on a new line. */

const input = require('sync-input');
let userLives = 8;
const word = getRandomWord();
let hiddenWord = '-'.repeat(word.length);

console.log('H A N G M A N');
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
        console.log('You guessed the word!');
        console.log('You survived!');
        break;
    }

    if (userLives === 0) {
        console.log('You lost!');
    }
}

function getUserInput() {
    console.log('Input a letter:');
    return input();
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