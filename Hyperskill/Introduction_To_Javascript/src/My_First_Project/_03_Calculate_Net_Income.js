/*Description
In the final stage, let's calculate the shop's net income. To do this, you need to retrieve staff and other expenses from the user
input and subtract them from the income you came up with in the previous stage. You don't need to change the previous functionality of your program,
but to expand it by adding both inputs and calculating the net income.

We've imported the sync-input library that you must use to take input from the user.

Objectives
In this stage, your program should:
    • Print the item names, what you earned for each of them and total earnings as before;
    • Ask users for staff expenses with the Staff expenses: string and for other expenses with the Other expenses: string;
    • Calculate and print the net income as shown below. Replace 0.0 with the actual net income */

const input = require('sync-input');
let income = 0

console.log("Earned amount:")
console.log("Bubblegum: $202")
income += 202
console.log("Toffee: $118")
income += 118
console.log("Ice cream: $2250")
income += 2250
console.log("Milk chocolate: $1680")
income += 1680
console.log("Doughnut: $1075")
income += 1075
console.log("Pancake: $80")
income += 80
console.log(`Income: $${income.toFixed(1)}`)

let netIncome = income
let expenses = Number(input("Staff expenses:"))

netIncome -= expenses
expenses = Number(input("Other expenses:"))
netIncome -= expenses
console.log(`Net income: $${netIncome.toFixed(1)}`)