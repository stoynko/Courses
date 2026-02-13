package Projects.Last_Pencil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Working_On_Gameplay {

/*Description
An interesting idea has come to your mind. Let's change the rules of game. Players take turns taking X pencils until none of them remain.

Objectives
Expand your program by creating a loop. Each player takes turns removing pencils until 0 pencils remain on the table.
Each iteration prints 2 lines: lines with pencils (vertical bars) and whose turn is now by printing the *NameX*'s turn string.
If there are no pencils left after a player's move, the loop breaks and the game ends without any additional output. */

    public static final String PEN_INPUT_PROMPT = "How many pencils would you like to use:";
    public static final String FIRST_TURN_PROMPT = "Who will be the first (%s):";
    public static final String PLAYER_TURN_OUTPUT = "%s's turn:";
    public static final String PEN_SYMBOL = "|";
    public static final List<String> NAMES_POOL = List.of("Jack", "John");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Player> players = createPlayers();

        System.out.println(PEN_INPUT_PROMPT);
        int pensCount = Integer.parseInt(scanner.nextLine());


        System.out.println(FIRST_TURN_PROMPT.formatted(players.stream().map(Player::getName).collect(Collectors.joining(", "))));
        String playerTurn = scanner.nextLine();
        int playerIndex = getPlayerIndex(players, playerTurn);
        System.out.println(PEN_SYMBOL.repeat(pensCount));

        while (pensCount > 0) {
            Player player = players.get(playerIndex);
            System.out.println(PLAYER_TURN_OUTPUT.formatted(player.getName()));

            int pencilsTaken = Integer.parseInt(scanner.nextLine());
            pensCount -= pencilsTaken;
            System.out.println(PEN_SYMBOL.repeat(pensCount));

            if (pensCount <= 0) {
                break;
            }

            playerIndex = (playerIndex + 1) % players.size();
        }
    }

    private static int getPlayerIndex(List<Player> players, String playerTurn) {
        int currentPlayerIndex = 0;

        for (int index = 0; index < players.size(); index++) {
            if (players.get(index).getName().equals(playerTurn)) {
                currentPlayerIndex = index;
                break;
            }
        }
        return currentPlayerIndex;
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
