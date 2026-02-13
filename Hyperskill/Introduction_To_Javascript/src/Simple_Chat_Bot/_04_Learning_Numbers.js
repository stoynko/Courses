/*Description:
Now you will teach your bot to count. It's going to become an expert in numbers!

Objective:
    • In this stage, you will program the bot to count from 0 to any positive number users enter. */

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
console.log("Now I will prove to you that I can count to any number you want.")
let userInput = Number(input())
let count = 0
while (count <= userInput) {
    console.log(count + "!")
    count++
}
console.log("Completed, have a nice day!")