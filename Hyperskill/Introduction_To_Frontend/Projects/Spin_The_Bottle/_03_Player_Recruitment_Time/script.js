let playersArray = [];

document.getElementById("spin").addEventListener("click", spinTheBottle);
document.getElementById("add-player").addEventListener("click", addPlayer);


function addPlayer() {
    let input = document.getElementById('player-name');
    let playersList = document.getElementById('players');
    let playerName = input.value.trim();
    let status = document.getElementById('status');

    if (playerName === "") {
        return;
    }

    if (!playersArray.includes(playerName)) {
        let li = document.createElement("li");
        li.textContent = playerName;
        playersArray.push(playerName);
        playersList.appendChild(li);
        input.value = "";
    } else {
        updateStatus("Player already exists!");
        return;
    }

    if (playersArray.length >= 1) {
        updateStatus("Spin the bottle!");
        return;
    }
}

function updateStatus(value) {
    let status = document.getElementById('status');
    status.textContent = value;
}

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

