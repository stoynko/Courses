package Projects.Last_Pencil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_Fair_Play {

/*Description
The game was interesting, but it went sour. No one was playing a fair game! You've taken 10 pencils,
your friend decided that it is unfair and somehow took a negative number! Moreover, you both can't decide which of you won.
Maybe, it's time to add new rules to the game.

Objectives
In this stage, your task is to add a new level of control over the game. Check the input. If it's incorrect, print the reason why.
Also, limit the possible amount of pencils taken. Let's say that players can remove not more than 3 pencils at a time.

Here are possible errors and their feedback:
    1. The initial number of pencils is not a numeric string, so it can't be converted to an integer — The number of pencils should be numeric;
    2. The initial number of pencils is equal to 0 — The number of pencils should be positive;
    3. If the input is a negative amount, apply condition (1), as the minus sign is not a numeric;
    4. If the chosen first player is not *Name1* or *Name2* — Choose between *Name1* and *Name2*;
    5. One of the players has taken the number of pencils that differs from 1, 2, or 3 — Possible values: '1', '2' or '3';
    6. One of the players has taken more pencils than there are on the table — Too many pencils were taken.

If one of the errors occurs, ask for input once again. Please note that when an error occurs, you don't need to print whose turn it is. Just output the error feedback.

Don't forget to help determine the winner of the game. The player who takes the last pencil loses the game.
Print out the result at the end of the game with the line *Winner-name* won! */

    public static final String PEN_INPUT_PROMPT = "How many pencils would you like to use:";
    public static final String FIRST_TURN_PROMPT = "Who will be the first (%s):";
    public static final String PLAYER_TURN_OUTPUT = "%s's turn!";
    public static final String PEN_SYMBOL = "|";
    public static final List<String> NAMES_POOL = List.of("Jack", "John");
    public static final String ERROR_PEN_INPUT_NUMERIC = "The number of pencils should be numeric";
    public static final String ERROR_PEN_INPUT_ZERO = "The number of pencils should be positive";
    public static final String ERROR_PEN_REMOVAL_INVALID_AMOUNT = "Possible values: '1', '2' or '3'";
    public static final String ERROR_PEN_REMOVAL_MAX_AMOUNT = "Too many pencils were taken";
    public static final String ERROR_PLAYER_SELECTION = "Choose between %s";
    public static final String WINNER_OUTPUT = "%s won!";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Player> players = createPlayers();

        System.out.println(PEN_INPUT_PROMPT);
        int pensCount = getInitialPenAmount(scanner);

        System.out.println(FIRST_TURN_PROMPT.formatted(players.stream().map(Player::getName).collect(Collectors.joining(", "))));
        int playerIndex = getFirstPlayerIndex(scanner, players);

        System.out.println(PEN_SYMBOL.repeat(pensCount));
        boolean isInputValid = true;

        while (pensCount > 0) {
            Player player = players.get(playerIndex);

            if (isInputValid) {
                System.out.println(PLAYER_TURN_OUTPUT.formatted(player.getName()));
            }

            int pencilsToTake = getPensToRemove(scanner);

            if (pencilsToTake > pensCount) {
                System.out.println(ERROR_PEN_REMOVAL_MAX_AMOUNT);
                isInputValid = false;
                continue;
            }

            pensCount -= pencilsToTake;

            if (pensCount == 0) {
                System.out.println(WINNER_OUTPUT.formatted(players.get((playerIndex + 1) % players.size()).getName()));
                break;
            }

            System.out.println(PEN_SYMBOL.repeat(pensCount));

            playerIndex = (playerIndex + 1) % players.size();
        }
    }

    private static int getPensToRemove(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();

            if (!input.matches("\\d+")) {
                System.out.println(ERROR_PEN_REMOVAL_INVALID_AMOUNT);
                continue;
            }

            int penAmount = Integer.parseInt(input);
            if (penAmount <= 0) {
                System.out.println(ERROR_PEN_REMOVAL_INVALID_AMOUNT);
                continue;
            }

            if (penAmount > 3) {
                System.out.println(ERROR_PEN_REMOVAL_INVALID_AMOUNT);
                continue;
            }

            return penAmount;
        }
    }

    private static int getFirstPlayerIndex(Scanner scanner, List<Player> players) {
        List<String> playerNames = players.stream().map(Player::getName).collect(Collectors.toList());

        while (true) {
            String selectedPlayer = scanner.nextLine();

            if (!playerNames.contains(selectedPlayer)) {
                String availablePlayers = String.join(" and ", playerNames);
                System.out.println(ERROR_PLAYER_SELECTION.formatted(availablePlayers));
                continue;
            }

            for (int index = 0; index < players.size(); index++) {
                if (selectedPlayer.equals(players.get(index).getName())) {
                    return index;
                }
            }
        }
    }

    private static int getInitialPenAmount(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty() || input.isBlank()) {
                System.out.println(ERROR_PEN_INPUT_NUMERIC);
                continue;
            }

            if (!input.matches("\\d+")) {
                System.out.println(ERROR_PEN_INPUT_NUMERIC);
                continue;
            }

            int pensAmount = Integer.parseInt(input);
            if (pensAmount <= 0) {
                System.out.println(ERROR_PEN_INPUT_ZERO);
                continue;
            }

            return pensAmount;
        }
    }

    private static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();

        for (String playerName : NAMES_POOL) {
            Player player = new Player(playerName);
            players.add(player);
        }

        return players;
    }

    public static class Player {

        private String name;

        public Player() {
            setName(name);
        }

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
