/*Description

Keep improving your bot by developing new skills for it. We suggest a simple guessing game that will predict the age of a user.
It's based on a simple math trick. First, take a look at this formula:
    age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105

The numbers remainder3, remainder5, and remainder7 are the remainders of division by 3, 5 and 7 respectively.
It turns out that for each number ranging from 0 to 104, the calculation will result in the number itself.
This perfectly fits the ordinary age range, doesn't it? Ask the user for the remainders and use them to guess the age!

Objective
In this stage, you will introduce yourself to the bot.
It will greet you by your name and then try to guess your age using arithmetic operations.

Your program should print the following lines:
    Hello! My name is Aid.
    I was created in 2023.
    Please, remind me your name.
    What a great name you have, Max!
    Let me guess your age.
    Enter remainders of dividing your age by 3, 5 and 7.
    Your age is {your_age}; that's a good time to start programming! */

const input = require('sync-input');
const botName = "Robby"
const birthYear = new Date().getFullYear()
console.log(`Hello! My name is ${botName}.`)
console.log(`I was created in ${birthYear}.`)
console.log("Please, remind me your name.")
let userName = input()
console.log(`What a great name you have, ${userName}!`)
console.log("Let me guess your age.")
console.log("Enter remainders of dividing your age by 3, 5 and 7.")

let remainder3 = Number(input())
let remainder5 = Number(input())
let remainder7 = Number(input())

userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
console.log(`Your age is ${userAge}; that's a good time to start programming!`)