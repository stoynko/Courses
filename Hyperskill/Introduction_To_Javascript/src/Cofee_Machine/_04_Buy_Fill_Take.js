/*Description

Let's simulate an actual coffee machine! What do we need for that? This coffee machine will have a limited supply of water, milk, coffee beans, and disposable cups.
Also, it will calculate how much money it gets for selling coffee.

There are several options for the coffee machine we want you to implement: first, it should sell coffee.
It can make different types of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies,
however, in any case, you will need only one disposable cup for a drink.
Second, the coffee machine must get replenished by a special worker.
Third, another special worker should be able to take out money from the coffee machine.

Objectives:
    Write a program that offers to buy one cup of coffee or to fill the supplies or to take its money out. Note that the program is supposed to do one of the mentioned actions at a time.
    It should also calculate the amounts of remaining ingredients and how much money is left. Display the quantity of supplies before and after purchase.
       1. First, your program reads one option from the standard input, which can be "buy", "fill", "take". If a user wants to buy some coffee,
          the input is "buy". If a special worker thinks that it is time to fill out all the supplies for the coffee machine,
          the input line will be "fill". If another special worker decides that it is time to take out the money from the coffee machine, you'll get the input "take".
       2. If the user writes "buy" then they must choose one of three types of coffee that the coffee machine can make: espresso, latte, or cappuccino.
        • For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
        • For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
        • And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
       3. If the user writes "fill", the program should ask them how much water, milk, coffee and how many disposable cups they want to add into the coffee machine.
       4. If the user writes "take" the program should give all the money that it earned from selling coffee.

At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.

To sum up, your program should print the coffee machine's state, process one query from the user, as well as print the coffee machine's state after that.
Try to use functions for implementing every action that the coffee machine can do.  */


const input = require('sync-input');

let coffeeMachine = {
    'beverages': [],
    'waterStorage': 400,
    'milkStorage': 540,
    'coffeeBeansStorage': 120,
    'disposableCups': 9,
    'cash': 550
}
turnMachineOn(coffeeMachine);

let userInput = getAction();
while (userInput !== 'buy' && userInput !== 'fill' && userInput !== 'take') {
    userInput = getAction();
}
switch (userInput) {
    case 'buy': let beverage = selectBeverage();
                if (beverageCanBePrepared(beverage)) {
                    prepareBeverage(coffeeMachine, beverage);
                    coffeeMachine.cash += beverage.price;
                    console.log('');
                    getMachineInfo(coffeeMachine);
                } break;
    case 'fill': refillCoffeeMachine(coffeeMachine); break;
    case 'take': cashOut(coffeeMachine); break;
}

function getAction() {
    console.log('Write action (buy, fill, take): ')
    return input();
}

function selectBeverage() {
    console.log('What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ')
    let userInput = Number(input());
    while (userInput !== 1 && userInput !== 2 && userInput !== 3) {
        userInput = input();
    }
    return coffeeMachine.beverages[userInput - 1];
}
function beverageCanBePrepared(beverage) {

    if (coffeeMachine.disposableCups === 0) {
        return false;
    }

    if ('waterReqPerCup' in beverage && coffeeMachine.waterStorage < beverage.waterReqPerCup) {
        return false;
    }

    if ('milkReqPerCup' in beverage && coffeeMachine.milkStorage < beverage.milkReqPerCup) {
        return false;
    }

    if ('coffeeReqPerCup' in beverage && coffeeMachine.coffeeBeansStorage < beverage.coffeeReqPerCup) {
        return false;
    }

    return true;
}

function prepareBeverage(coffeeMachine, beverage) {
    coffeeMachine.disposableCups -= 1;
    if ('waterReqPerCup' in beverage) {
        coffeeMachine.waterStorage -= beverage.waterReqPerCup;
    }

    if ('milkReqPerCup' in beverage) {
        coffeeMachine.milkStorage -= beverage.milkReqPerCup;
    }

    if ('coffeeReqPerCup' in beverage) {
        coffeeMachine.coffeeBeansStorage -= beverage.coffeeReqPerCup;
    }
}

function refillCoffeeMachine(coffeeMachine) {
    console.log('Write how many ml of water the coffee machine has:')
    coffeeMachine.waterStorage += Number(input());
    console.log('Write how many ml of milk the coffee machine has:')
    coffeeMachine.milkStorage += Number(input());
    console.log('Write how many grams of coffee beans the coffee machine has:')
    coffeeMachine.coffeeBeansStorage += Number(input());
    console.log('Write how many disposable cups you want to add: ')
    coffeeMachine.disposableCups += Number(input());
    console.log('');
    getMachineInfo(coffeeMachine);
}

function cashOut(coffeeMachine) {
    console.log(`I gave you $${coffeeMachine.cash}`);
    coffeeMachine.cash = 0;
    console.log('');
    getMachineInfo(coffeeMachine);
}

function getMachineInfo(coffeeMachine) {
    console.log('The coffee machine has:');
    console.log(`${coffeeMachine.waterStorage} ml of water`);
    console.log(`${coffeeMachine.milkStorage} ml of milk`);
    console.log(`${coffeeMachine.coffeeBeansStorage} g of coffee beans`);
    console.log(`${coffeeMachine.disposableCups} disposable cups`);
    console.log(`$${coffeeMachine.cash} of money`);
    console.log('');
}

function calculateCoffeeProduction(coffeeMachine, coffeeCups) {
    let cupsToWater = coffeeMachine.waterStorage / waterReqPerCup;
    let cupsToMilk = coffeeMachine.milkStorage / milkReqPerCup;
    let cupsToCoffeeBeans = coffeeMachine.coffeeBeansStorage / coffeeReqPerCup;
    return Math.floor(Math.min(cupsToWater, Math.min(cupsToMilk, cupsToCoffeeBeans)));
}

function turnMachineOn(coffeeMachine) {
    let espresso = {
        'waterReqPerCup': 250,
        'coffeeReqPerCup': 16,
        'price': 4
    }

    let latte = {
        'waterReqPerCup': 350,
        'milkReqPerCup': 75,
        'coffeeReqPerCup': 20,
        'price': 7
    }

    let cappuccino = {
        'waterReqPerCup': 200,
        'milkReqPerCup': 100,
        'coffeeReqPerCup': 12,
        'price': 6
    }
    coffeeMachine.beverages.push(espresso, latte, cappuccino);
    getMachineInfo(coffeeMachine);
}