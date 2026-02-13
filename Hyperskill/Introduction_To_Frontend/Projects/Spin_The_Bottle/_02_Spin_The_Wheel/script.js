let playersArray = ["Player 1", "Player 2", "Player 3", "Player 4", "Player 5", "Player 6"];

function spinTheBottle() {
    let spinStatus = document.getElementById("status");
    spinStatus.textContent = "Spinning..."

    setTimeout(() => {
        let winner = getRandomPlayer();
        spinStatus.textContent = "Selected player: " + winner;
    }, 2000);
}


function getRandomPlayer() {
    let randomInt = Math.floor(Math.random() * playersArray.length);
    return playersArray[randomInt];
}


document.getElementById("spin").addEventListener("click", spinTheBottle);