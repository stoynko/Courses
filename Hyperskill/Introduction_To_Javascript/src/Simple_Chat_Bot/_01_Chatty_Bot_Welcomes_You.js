/* Description
Digital personal assistants help people to drive cars, plan their day, buy something online.
In a sense, they are simplified versions of artificial intelligence with whom you can talk.
In this project, you will develop step by step a simple bot that will help you study programming.

Objective:
    • For the first stage, you will write a bot who displays a greeting,
      its name, and the year it was created. First impressions count!

Your program should print the following lines:
    Hello! My name is {bot_name}.
    I was created in {birth_year}. */

const botName = "Robby"
const birthYear = new Date().getFullYear()
console.log(`Hello! My name is ${botName}.`)
console.log(`I was created in ${birthYear}.`)