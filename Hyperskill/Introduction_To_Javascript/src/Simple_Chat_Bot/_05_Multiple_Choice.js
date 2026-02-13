/*Description

At the final stage, you will improve your simple bot so that it can give you a test and check your answers.
The test should be a multiple-choice quiz about programming with any number of options.
Your bot has to repeat the test until you answer correctly and congratulate you upon completion.

Objective:
Your bot can ask anything you want, but there are two rules for your output:
    • the line with the test should end with the question mark character;
    • an option starts with a digit followed by the dot (1., 2., 3., 4.)

If a user enters an incorrect answer, the bot may print a message:
    • Please, try again.

The program should stop on the correct answer and print Congratulations, have a nice day! at the end.*/

const input = require('sync-input');
const botName = "Robby"
const birthYear = new Date().getFullYear()

function greetings() {
    console.log(`Hello! My name is ${botName}.`)
    console.log(`I was created in ${birthYear}.`)
    console.log("Please, remind me your name.")
    let userName = input()
    console.log(`What a great name you have, ${userName}!`)
}

function guessAge() {
    console.log("Let me guess your age.")
    console.log("Enter remainders of dividing your age by 3, 5 and 7.")

    let remainder3 = Number(input())
    let remainder5 = Number(input())
    let remainder7 = Number(input())

    userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
    console.log(`Your age is ${userAge}; that's a good time to start programming!`)
}

function count() {
    console.log("Now I will prove to you that I can count to any number you want.")
    let userInput = Number(input())
    let count = 0
    while (count <= userInput) {
        console.log(count + "!")
        count++
    }
}
function quiz() {
    console.log("Let's test your programming knowledge.")
    console.log("Is this a JavaScript project?")
    console.log("1. Yes")
    console.log("2. No")
    while (true) {
        let userInput = Number(input())
        if (userInput == 1) {
            break;
        }
        console.log("Please, try again.")
    }
    console.log("Congratulations, have a nice day!")
}

greetings()
guessAge()
count()
quiz()