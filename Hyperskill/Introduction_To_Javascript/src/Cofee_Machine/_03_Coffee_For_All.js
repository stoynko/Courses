/*Description

A real coffee machine doesn't have an infinite supply of water, milk, or coffee beans. And if you input a really big number,
it's almost certain that a real coffee machine wouldn't have the supplies needed to make all that coffee for you. In this stage,
you need to improve the previous program. Now you will check amounts of water, milk, and coffee beans available in your coffee machine at the moment.

Objectives:
    Write a program that does the following:
        • It requests the amounts of water, milk, and coffee beans available at the moment, and then asks for the number of cups a user needs.
        • If the coffee machine has enough supplies to make the specified amount of coffee, the program should print "Yes, I can make that amount of coffee".
        • If the coffee machine can make more than that, the program should output "Yes, I can make that amount of coffee (and even N more than that)",
          where N is the number of additional cups of coffee that the coffee machine can make.
        • If the amount of given resources is not enough to make the specified amount of coffee, the program should output "No, I can make only N cups of coffee".

Like in the previous stage, the coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans to make one cup of coffee. */

const input = require('sync-input');
const waterReqPerCup = 200;
const milkReqPerCup = 50;
const coffeeReqPerCup = 15;

coffeeMachine = {
    'waterStorage': 0,
    'milkStorage': 0,
    'coffeeBeansStorage': 0
}

refillCoffeeMachine(coffeeMachine);

console.log('Write how many cups of coffee you will need:');
let userRequest = Number(input());
let minCups = calculateCoffeeProduction(coffeeMachine, )
if (minCups >= userRequest) {
    if (minCups === userRequest) {
        console.log('Yes, I can make that amount of coffee');
    } else {
        console.log(`Yes, I can make that amount of coffee (and even ${minCups - userRequest} more than that)`);
    }
} else {
    console.log(`No, I can make only ${minCups} cups of coffee`);
}


function refillCoffeeMachine(coffeeMachine) {
    console.log('Write how many ml of water the coffee machine has:')
    coffeeMachine.waterStorage = Number(input());
    console.log('Write how many ml of milk the coffee machine has:')
    coffeeMachine.milkStorage = Number(input());
    console.log('Write how many grams of coffee beans the coffee machine has:')
    coffeeMachine.coffeeBeansStorage = Number(input());
}

function calculateCoffeeProduction(coffeeMachine, coffeeCups) {
    let cupsToWater = coffeeMachine.waterStorage / waterReqPerCup;
    let cupsToMilk = coffeeMachine.milkStorage / milkReqPerCup;
    let cupsToCoffeeBeans = coffeeMachine.coffeeBeansStorage / coffeeReqPerCup;
    return Math.floor(Math.min(cupsToWater, Math.min(cupsToMilk, cupsToCoffeeBeans)));
}