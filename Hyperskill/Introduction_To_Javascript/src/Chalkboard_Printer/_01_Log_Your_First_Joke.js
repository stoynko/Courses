/*In the show's intro, Bart Simpson is tasked with writing a message multiple times on a chalkboard as a punishment.
Too bad he didn't know programming for this task. Luckily, you know how to create a JavaScript program to do this.
Like Bart Simpson, you must create a JavaScript program to log a message to the console multiple times.

In this stage, you will notice we've declared the variables you need to use. However, we've made a mistake.
Correct the error, assign the necessary values from the objectives section, and log the message five times.

Make sure to follow the output style given in the examples.

Objectives
You should:
    • Declare a variable named name and assign the value Bart to it.
    • Declare a variable named surname and assign the value Simpson to it.
    • Declare a variable named message and assign the value I will not skateboard in the halls. to it.
    • Log this message to the console using the variables above five times: This is [name] [surname] and [message] */

const name = "Bart"
const surname = "Simpson"
const message = "I will not skateboard in the halls."

let count = 1
while (count <= 5) {
    writeMessage(name, surname, message)
    count++
}

function writeMessage(name, surname, message) {
    console.log(`This is ${name} ${surname} and ${message}`)
}