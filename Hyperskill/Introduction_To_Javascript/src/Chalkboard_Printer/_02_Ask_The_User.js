/*Description:
Time to add some energy to our project! In this stage, instead of using static values,
you will get input from the user and log the messages according to the user's input.
We've imported the sync-input library that you must use to take input from the user.

Follow the output style given in the examples.

You should:
    • Take the input for the name variable.
    • Take the input for the surname variable.
    • Take the input for the message variable.
    • Log this message to the console using the variables above five times:
        This is [name] [surname] and [message] */

const input = require('sync-input');
let name = input()
let surname = input()
let message = input()

let count = 1
while (count <= 5) {
    writeMessage(name, surname, message)
    count++
}

function writeMessage(name, surname, message) {
    console.log(`This is ${name} ${surname} and ${message}`)
}