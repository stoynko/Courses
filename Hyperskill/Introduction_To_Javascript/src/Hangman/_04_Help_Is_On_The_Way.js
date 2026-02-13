/* Description

The game is now more difficult to beat; your chances of guessing the word depend on the list size. 
If there are four words in the list, you have a 25% chance. 
Let's show a little mercy and add hints for our players.

Objectives:
    • As in the previous stage, use the following word list: python, java, swift, javascript;
    • Once the computer has chosen a word from the list, show its first three letters. Replace the hidden letters with hyphens (-). */

const input = require('sync-input');

console.log("H A N G M A N");
console.log("Guess the word:");

const wordsRepo = ['python', 'java', 'swift', 'javascript'];
const wordToGuess = getRandomWord(wordsRepo);
let displayWord = hideLetters(wordToGuess);
const userInput = input();
let gameOutcome = determineOutcome(userInput, wordToGuess);
displayOutcome(gameOutcome);

function determineOutcome(userInput, wordToGuess) {
    return userInput.trim() === wordToGuess;
}

function displayOutcome(gameOutcome) {
    if (gameOutcome) {
        console.log("You survived!")
    } else {
        console.log("You lost!")
    }
}

function getRandomWord(wordsRepo) {
    let randomNumber = Math.floor(Math.random() * wordsRepo.length);
    return wordsRepo[randomNumber]
}

function hideLetters(input) {
    let inputArr = input.split('');
    for (let i = 0; i <= inputArr.length - 1; i++) {
          if (i > 2) {
              inputArr[i] = '-';
          }
    }
    return inputArr.join('');
}