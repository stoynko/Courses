/* Description
Let's make the game iterative. In this stage, we'll adjust our game to resemble the classic version of Hangman.
Players should now guess the letters in a word instead of inputting an entire word. If an attempt is successful, uncover the letter.
We also need to add the lose condition — players have eight attempts to guess all letters that appear in the word.
When players run out of attempts, the game ends.

Objectives:
    Your game should work as follows:
    • Players have exactly eight attempts to guess the word by entering letters one by one. Asking for a letter, print:
        Input a letter:. If a player uncovered all the letters, but some attempts are still left,
        the program must continue to ask for input until all the tries are exhausted;
    • If the letter doesn't appear in the word, the computer takes one try away – even if a user has already suggested this letter – and prints
        That letter doesn't appear in the word.;
    • If the letter does appear in the word but a user has already suggested this letter and it's open, no need to print any messages;
    • If all attempts are exhausted, the game ends; the program shows a final message (Thanks for playing!).
        Otherwise, players can continue to input letters;
    • We continue to stick with the word list from the previous stage: python, java, swift, javascript.
        It ensures that your program is tested reliably. Don't worry about javascript. Yes, it's longer than 8 characters,
        but we'll keep it in the list for consistency since we're not done with developing the game yet and for now there is no win or lose. */

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
    } else {
        let wordIndexes = getLetterIndexes(guess, word);
        if (wordIndexes.length === 0) {
            console.log("That letter doesn't appear in the word.");
            console.log('');  // blank line after message only
        } else {
            for (const idx of wordIndexes) {
                hiddenWord = revealLetter(word, hiddenWord, idx);
            }
        }
    }
    userLives--;
    console.log(hiddenWord);
}

console.log('Thanks for playing!');

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