/*Description:
Since we have dynamic input from the user, let's add the ability to log more messages on the console.
In this stage, you'll take input for the number of times the message will repeat.
After that, you will use the input to repeat the messages.
Follow the output style given in the examples.

Objectives
    You should:
    • Use the variables from the previous stages.
    • Take the input for the number of repeats.
    • Log this message to the console using the number of repeats times: This is [name] [surname] and [message] */

const input = require('sync-input');
let name = input()
let surname = input()
let message = input()
let count = input()

for (let i = 1; i <= count; i++) {
    writeMessage(name, surname, message)
}

function writeMessage(name, surname, message) {
    console.log(`This is ${name} ${surname} and ${message}`)
}

console.log("Welcome to the Chalkboard Printer!");