/*Description

Now let's consider a case when you need a lot of coffee. Maybe you're hosting a party with a lot of guests! In these circumstances,
it's better to make preparations in advance. So, we will ask a user to enter the desired amount of coffee, in cups.
Given this, you can adjust the program by calculating how much water, coffee, and milk are necessary to make the specified amount of coffee.
Of course, all this coffee is not needed right now, so at this stage, the coffee machine doesn't actually make any coffee yet.

Objectives:
    Let's break the task into several steps:
        • First, read the numbers of coffee drinks from the input.
        • Figure out how much of each ingredient the machine will need. Note that one cup of coffee made on this coffee machine contains 200 ml of water,
          50 ml of milk, and 15 g of coffee beans.
        • Output the required ingredient amounts back to the user. */

const input = require('sync-input');
const waterReqPerCup = 200;
const milkReqPerCup = 50;
const coffeeReqPerCup = 15;


console.log('Write how many cups of coffee you will need:');
let cups = getUserInput();
console.log(`For ${cups} cups of coffee you will need:`)
console.log(`${cups * waterReqPerCup} ml of water`)
console.log(`${cups * milkReqPerCup} ml of milk`)
console.log(`${cups * coffeeReqPerCup} g of coffee beans`)

function getUserInput() {
    return input();
}