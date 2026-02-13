/*Description:

A month has passed since the opening of your shop. Let's calculate the total earnings for this period! You know the total earned amount for each item:
┌───────────────────┬───────────────┐
│ Item name         │ Earned amount │
├───────────────────┼───────────────┤
│ Bubblegum         │ $202          │
├───────────────────┼───────────────┤
│ Toffee            │ $118          │
├───────────────────┼───────────────┤
│ Ice cream         │ $2250         │
├───────────────────┼───────────────┤
│ Milk chocolate    │ $1680         │
├───────────────────┼───────────────┤
│ Doughnut          │ $1075         │
├───────────────────┼───────────────┤
│ Pancake           │ $80           │
└───────────────────┴───────────────┘

Use the above data to find the total income for the first month and log the results as shown below.
Objectives:

In this stage, your program should:
    • Print the Earned amount: line.
    • Print the item names and the earned amount for each of them;
    • Print the total earnings as shown below. Replace 0.0 with the actual total sum. */

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