/*Description:
In this stage, we will start converting a provided amount of USD to the list of currencies in the first stage.
First, print a message to let users know what the program can do:

"I can convert USD to these currencies: JPY, EUR, RUB, USD, GBP
Type the currency you wish to convert: USD"

Get input from users like in the example. Calculate and output the result that must take 4 decimal places.
To simplify getting input from the console, we're using a JS library, check out the documentation to see how it's used.
Don’t forget that when getting the input for the desired currency, the program should be able to process lower and uppercase letters.
Also, if an unknown input is provided by users, print the following message and stop the program: Unknown currency.
The value for the converted amount should not be less than 1. If it's less, output The amount cannot be less than 1.
If the amount is not a number, output The amount has to be a number.

Objectives:
    In this stage, your program should output:
        • Output a new message about what it can do;
        • Ask for the currency and amount;
        • Calculate and output the correct result;
        • Handle any uppercased or lowercased inputs;
        • Handle unknown currency input;
        • Handle an amount that is less than 1; */

const input = require('sync-input');

console.log('Welcome to Currency Converter!');
console.log('1 USD equals 1 USD');
console.log('1 USD equals 113.5 JPY');
console.log('1 USD equals 0.89 EUR');
console.log('1 USD equals 74.36 RUB');
console.log('1 USD equals 0.75 GBP');
console.log('I can convert USD to these currencies: JPY, EUR, RUB, USD, GBP')

let supportedCurrencies = getCurrencyData();

console.log('Type the currency you wish to convert: USD')
let baseCurrency = processCurrency('USD', supportedCurrencies);

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

console.log(`Result: ${amount} ${baseCurrency.standard} equals ${(amount * toCurrency.rate).toFixed(4)} ${toCurrency.standard}`)

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

function getCurrencyData() {
    return [
        {standard: 'USD', rate: 1},
        {standard: 'JPY', rate: 113.5},
        {standard: 'EUR', rate: 0.89},
        {standard: 'RUB', rate: 74.36},
        {standard: 'GBP', rate: 0.75}
    ];
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

function isCurrencySupported(currencyStandard, supportedCurrencies) {
    for (let currency of supportedCurrencies) {
        if (currency.standard === currencyStandard) {
            return {supported: true, standard: currency.standard, rate: currency.rate};
        }
    }
    return {supported: false};
}