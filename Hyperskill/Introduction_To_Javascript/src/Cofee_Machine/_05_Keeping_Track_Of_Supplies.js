/*Description

Just one action is not so interesting, is it? Let's improve the program so it can do multiple actions, one after another. It should repeatedly ask a user what they want to do.
If the user types "buy", "fill" or "take", then the program should do exactly the same thing it did in the previous step. However, if the user wants to switch off the coffee machine, they should type "exit".
The program should terminate on this command. Also, when the user types "remaining", the program should output all the resources that the coffee machine has.
This means that you shouldn't show the remaining stock levels at the beginning/end of the program.

Remember, that:
    • For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
    • For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
    • And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.

Objectives:
    • Write a program that will work endlessly to make coffee for all interested people until the shutdown signal is given.
      Introduce two new options: "remaining" and "exit".
    • Do not forget that you can be out of resources for making coffee. If the coffee machine doesn't have enough resources to make coffee,
      the program should output a message that says it can't make a cup of coffee and state what is missing.
    • And the last improvement to the program at this step — if the user types "buy" to buy a cup of coffee and then changes his mind,
      they should be able to type "back" to return into the main cycle.*/


const input = require('sync-input');
let coffeeMachine = turnCoffeeMachineOn();

while (coffeeMachine.state === 'on') {

    let userInput = getAction();

    switch (userInput) {
        case 'buy':
            let beverage = selectBeverage();
            if (beverage === null) {
                break;
            }
            let resourceState = beverageCanBePrepared(beverage);
            if (resourceState.ok) {
                console.log('I have enough resources, making you a coffee!');
                prepareBeverage(coffeeMachine, beverage);
                coffeeMachine.cash += beverage.price;
            } else {
                console.log(`Sorry, not enough ${resourceState.missing}!`);
            }
            break;
        case 'fill': refillCoffeeMachine(coffeeMachine); break;
        case 'take': cashOut(coffeeMachine); break;
        case 'remaining': getMachineInfo(coffeeMachine); break;
        case 'exit': coffeeMachine.state = 'off'; break;
    }
}

function getAction() {
    console.log('Write action (buy, fill, take, remaining, exit): ')
    return input();
}

function selectBeverage() {
    console.log('What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ');
    let userInput = input();
    while (userInput !== 'back' && Number(userInput) !== 1 && Number(userInput) !== 2 && Number(userInput) !== 3) {
        userInput = input();
    }

    if (userInput === 'back') {
        return null;
    } else {
        return coffeeMachine.beverages[Number(userInput) - 1];
    }
}
function beverageCanBePrepared(beverage) {

    let resourceState = [];

    if (coffeeMachine.disposableCups === 0) {
        return { ok: false, missing: 'cups' };
    }

    if ('waterReqPerCup' in beverage && coffeeMachine.waterStorage < beverage.waterReqPerCup) {
        return { ok: false, missing: 'water' };
    }

    if ('milkReqPerCup' in beverage && coffeeMachine.milkStorage < beverage.milkReqPerCup) {
        return { ok: false, missing: 'milk' };
    }

    if ('coffeeReqPerCup' in beverage && coffeeMachine.coffeeBeansStorage < beverage.coffeeReqPerCup) {
        return { ok: false, missing: 'coffee' };
    }

    return { ok: true };
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
    console.log('Write how many ml of water you want to add:');
    coffeeMachine.waterStorage += Number(input());
    console.log('Write how many ml of milk you want to add:');
    coffeeMachine.milkStorage += Number(input());
    console.log('Write how many grams of coffee beans you want to add:');
    coffeeMachine.coffeeBeansStorage += Number(input());
    console.log('Write how many disposable cups you want to add:');
    coffeeMachine.disposableCups += Number(input());
}

function cashOut(coffeeMachine) {
    console.log(`I gave you $${coffeeMachine.cash}`);
    coffeeMachine.cash = 0;
}

function getMachineInfo(coffeeMachine) {
    console.log('');
    console.log('The coffee machine has:');
    console.log(`${coffeeMachine.waterStorage} ml of water`);
    console.log(`${coffeeMachine.milkStorage} ml of milk`);
    console.log(`${coffeeMachine.coffeeBeansStorage} g of coffee beans`);
    console.log(`${coffeeMachine.disposableCups} disposable cups`);
    console.log(`$${coffeeMachine.cash} of money`);
    console.log('');
}

function turnCoffeeMachineOn() {

    let coffeeMachine = {
        'beverages': [],
        'waterStorage': 400,
        'milkStorage': 540,
        'coffeeBeansStorage': 120,
        'disposableCups': 9,
        'cash': 550,
        'state': 'on'
    }

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
    return coffeeMachine;
}