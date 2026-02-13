/*Description

If there is only one word, the game becomes dull. You already know the word, and there’s no challenge.
In this stage, let's make the game more difficult by choosing a word from the special list with a variety of options.
This way, our game gains in replayability.

Objectives:
    • Create the following list of words: python, java, swift, javascript;
    • Program the game to choose a word from the list at random (you can use the Math.random() method for that).
      You can enter more words, but let's stick to these four for now. */

const input = require('sync-input');

console.log("H A N G M A N");
console.log("Guess the word:");

const wordsRepo = ['python', 'java', 'swift', 'javascript'];
let wordToGuess = getRandomWord(wordsRepo);
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