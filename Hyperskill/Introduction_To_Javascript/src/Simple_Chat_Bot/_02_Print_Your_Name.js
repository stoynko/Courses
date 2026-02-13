/*Description
The greeting part is great, but chatbots are also supposed to interact with a user.
It's time to implement this functionality.

Objective:
In this stage, you will introduce yourself to the bot so that it can greet you by your name.

Your program should print the following lines:
    Hello! My name is Aid.
    I was created in 2023.
    Please, remind me your name.
    What a great name you have, {your_name}!

You may change the name and the creation year of your bot if you want.

Instead of {your_name}, the bot must print your name entered from the standard input.*/

const input = require('sync-input');
const botName = "Robby"
const birthYear = new Date().getFullYear()
console.log(`Hello! My name is ${botName}.`)
console.log(`I was created in ${birthYear}.`)
console.log("Please, remind me your name.")
let userName = input()
console.log(`What a great name you have, ${userName}!`)