/*Description:
In this stage, we need to adjust our program to start converting all currencies between themselves.
First, remove the previous message:

"I can convert USD to these currencies: JPY, EUR, RUB, USD, GBP
Type the currency you wish to convert: USD"

Then, output the following message: What do you want to convert? After this, users provide input that indicates a currency to convert from.
Don't forget to handle all unknown and invalid inputs like in the previous stage.

Objectives:
    In this stage, your program should output:
        • Ask for the currencies
        • Calculate and output the result;
        • Handle any unknown and incorrect inputs. */

const input = require('sync-input');
const supportedCurrencies = getCurrencyData();

console.log('Welcome to Currency Converter!');
console.log('1 USD equals 1 USD');
console.log('1 USD equals 113.5 JPY');
console.log('1 USD equals 0.89 EUR');
console.log('1 USD equals 74.36 RUB');
console.log('1 USD equals 0.75 GBP');
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
let output = calculate(baseCurrency, toCurrency, amount)
console.log(`Result: ${amount} ${baseCurrency.standard} equals ${output.toFixed(4)} ${toCurrency.standard}`)

function calculate(baseCurrency, toCurrency, amount) {
    let usdValue = amount / baseCurrency.rate;
    return usdValue * toCurrency.rate;
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