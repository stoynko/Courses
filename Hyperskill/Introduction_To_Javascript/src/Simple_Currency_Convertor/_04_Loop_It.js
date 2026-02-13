/*Description:
In the final stage, we will loop our program to make it run continuously until the exit command is prompted. First, ask the user what they want to do: What do you want to do?
Give two choices to users: one is conversion, the other is the exit. Users need to input 1 and 2, respectively: 1-Convert currencies 2-Exit program
In case of any wrong input, you need to ask again for the input and repeat the process. Print the following message when users choose to exit the program: Have a nice day!

Print the following message when unknown input occurs: Unknown input

Objectives:
    In this stage, your program should output:
        • Continuously ask for new currency input;
        • Give two choices to users;
        • Handle unknown inputs. */

const input = require('sync-input');
const supportedCurrencies = getCurrencyData();

console.log('Welcome to Currency Converter!');
console.log('1 USD equals 1 USD');
console.log('1 USD equals 113.5 JPY');
console.log('1 USD equals 0.89 EUR');
console.log('1 USD equals 74.36 RUB');
console.log('1 USD equals 0.75 GBP');
let userInput = getUserInput();

while (true) {
    userInput = Number(userInput);
    switch (userInput) {
        case 1:
            initConversion();
            break;
        case 2:
            console.log('Have a nice day!');
            return;
        default:
            console.log('Unknown input');
    }

    userInput = getUserInput();
}

function getUserInput() {
    console.log('What do you want to do?');
    console.log('1-Convert currencies 2-Exit program');
    return input();
}

function initConversion() {
    console.log('What do you want to convert?');
    console.log('From:')
    let baseCurrency = processCurrency(input(), supportedCurrencies);

    if (baseCurrency == null) {
        return;
    }

    console.log('To:')
    let toCurrency = processCurrency(input(), supportedCurrencies);

    if (toCurrency === null) {
        return;
    }

    console.log('Amount:');
    let amount = Number(input());
    if (!isAmountValid(amount)) {
        return;
    }
    let output = calculate(baseCurrency, toCurrency, amount);
    console.log(`Result: ${amount} ${baseCurrency.standard} equals ${output.toFixed(4)} ${toCurrency.standard}`);
}

function processCurrency(input, supportedCurrencies) {
    let formattedInput = input.trim().toUpperCase();
    let result = isCurrencySupported(formattedInput, supportedCurrencies)
    if (!result.supported) {
        console.log('Unknown currency');
        return null;
    }
    return result;
}

function isAmountValid(amount) {
    if (Number.isNaN(amount)) {
        console.log('The amount has to be a number');
        return false;
    }

    if (amount < 1) {
        console.log('The amount cannot be less than 1');
        return false;
    }

    return true;
}

function calculate(baseCurrency, toCurrency, amount) {
    let usdValue = amount / baseCurrency.rate;
    return usdValue * toCurrency.rate;
}

function getCurrencyData() {
    return [
        {standard: 'USD', rate: 1},
        {standard: 'JPY', rate: 113.5},
        {standard: 'EUR', rate: 0.89},
        {standard: 'RUB', rate: 74.36},
        {standard: 'GBP', rate: 0.75}
    ];
}

function isCurrencySupported(currencyStandard, supportedCurrencies) {
    for (let currency of supportedCurrencies) {
        if (currency.standard === currencyStandard) {
            return {supported: true, standard: currency.standard, rate: currency.rate};
        }
    }
    return {supported: false};
}

