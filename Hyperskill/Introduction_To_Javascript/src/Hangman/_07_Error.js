/* Description
The skeleton of the game is ready; let's put some more gameplay meat on it.
In the previous stage, if players entered the same letter twice or more, the program reduced the number of remaining attempts regardless of whether this was a correct letter or not.
This doesn’t seem fair, right? Players gain nothing, and the number of attempts gets smaller. Let's fix it!

Objectives:
  To complete this stage, follow the suggested order of the required checks:
    • Check whether players enter exactly one letter. If not, print "Please, input a single letter.";
    • Make sure that the player entered a lowercase English letter. If not, the program should print "Please, enter a lowercase letter from the English alphabet."
      Remember that when players input nothing or non-letter characters, it shouldn't count as a correct input either;
    • If users enter the same letter twice (doesn't matter whether it appears in the word or not), then the program should output "You've already guessed this letter.".
      Do not decrease the number of attempts in this case;
    • None of the three errors described above should reduce the number of remaining attempts!
    • When players win, print You guessed the word <word>!, where <word> should be substituted with the uncovered word, and the winning message.
      Each one should be on a new line. */

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
        console.log(`You guessed the word ${word}!`);
        console.log('You survived!');
        break;
    }

    if (userLives === 0) {
        console.log('You lost!');
    }
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