/*Description:
In this stage, we will add some simple gameplay. There will be two possible outcomes.
Let's first print a welcoming message and then ask players to guess the word we have set for the game.
If they guess the word, the game reports a win; otherwise, it will "hang" the player.

Objectives:

    • Ask players for a possible word;
    • Print You survived! if users guess the word;
    • Print You lost! if users fail.

In this stage, python is the word that players need to guess. For now, this is the only form of answer that is deemed correct,
so there is no need to worry about the register or punctuation marks. */

const input = require('sync-input')

console.log("H A N G M A N")
console.log("Guess the word:")

const wordToGuess = 'python'
let userInput = input()
let gameOutcome = determineOutcome(userInput, wordToGuess)
displayOutcome(gameOutcome)

function determineOutcome(userInput, wordToGuess) {
    return Number(wordToGuess.localeCompare(userInput)) === 0;
}

function displayOutcome(gameOutcome) {
    if (gameOutcome) {
        console.log("You survived!")
    } else {
        console.log("You lost!")
    }
}
