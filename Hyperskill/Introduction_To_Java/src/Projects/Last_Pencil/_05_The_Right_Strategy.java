package Projects.Last_Pencil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_The_Right_Strategy {

/*Description
    You've played a couple of games with your friend. After a while, you both found out that if there are 2, 3, or 4 pencils left on the table,
    you automatically win. It happens because a player can take 1, 2, or 3 pencils and leave the other player with only one.
    The other player has nothing left but to take the last pencil and lose the game.

    On the other hand, if you have 5 pencils on the table, you lose. You can take 1, 2, or 3 pencils,
    your friend will then take 1, 2, or 3 pencils as well leaving you with the last pencil.
            So, it will again lead to the situation described above but vice-versa.

    The same thing happens when there are 6, 7, or 8 pencils left on the table. It will eventually repeat all over again.
            It's easier to get a grasp of it with a line of 10 red-green pencils. In this example,
    we can be sure that if both players know the winning strategy, the first one will be the winner. Here is a game process:

    Your friend came up with the idea of creating a bot to make the game a bit more replayable.
    Instead of taking input from two players, you need to program a bot that follows a winning strategy.
    If the bot's position isn't the winning one, you can program it to take any number of pencils (1, 2, or 3) at random.
    You can also come up with any pattern of your own for the losing position.

    To make it easier to understand, the logic of the bot could look like this:
            1. If the bot is in a losing position, the outcome of the game does not depend on his action, so if the number of pencils on the table in his turn is:
            • 5,9,13,17... - bot takes a random number of pencils from 1 to 3
            • 1 - bot takes the last pencil and loses

    2. If the bot is in a winning position, his goal is to take as many pencils to put his opponent in a losing position, so if the number of pencils on the table in his turn:
            • 4,8,12,16... - bot takes 3 pencils
        • 3,7,11,15... - bot takes 2 pencils
        • 2,6,10,14... - bot takes 1 pencil

            Objectives
    Implement the bot for the second of the two possible players. For example,
    in Who will be the first (John, Jack) John is the user and Jack is the bot (and will always be the bot).
    So, if the player chooses Jack as the first player, after that input, the bot's move should be printed.

    Your final objective is to expand your program. Write a solution, that can be executed for any initial number of pencils.
    Check each iteration whose turn is now. If it is the bot, instead of requiring input from the second player,
    output one line that contains the bot's move (1, 2 or 3) that follows the winning strategy. If the bot is not in the winning position,
    make it follow any pattern of your liking, as the tests check only the bot's winning position. */

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

        while (pensCount > 0) {

            Player player = players.get(playerIndex);
            System.out.println(PLAYER_TURN_OUTPUT.formatted(player.getName()));

            int pencilsToTake;

            while (true) {
                pencilsToTake = getPensToRemove(scanner, player, pensCount);

                if (pencilsToTake > pensCount) {
                    System.out.println(ERROR_PEN_REMOVAL_MAX_AMOUNT);
                } else {
                    break;
                }
            }
            pensCount -= pencilsToTake;

            if (pensCount == 0) {
                System.out.println(WINNER_OUTPUT
                        .formatted(players.get((playerIndex + 1) % players.size()).getName()));
                break;
            }

            System.out.println(PEN_SYMBOL.repeat(pensCount));
            playerIndex = (playerIndex + 1) % players.size();
        }
    }

    private static int getPensToRemove(Scanner scanner, Player player, int pensCount) {

        if (player.isBot) {
            boolean inLosingPosition = isInLosingPosition(pensCount);

            if (inLosingPosition && pensCount > 1) {
                Random random = new Random();
                return random.nextInt(1, 4);
            }

            if (inLosingPosition && pensCount == 1) {
                return pensCount;
            }

            if (!inLosingPosition) {
                return getMaximumPensToTake(pensCount);
            }
        }
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

    private static int getMaximumPensToTake(int pensCount) {

        int remainder = pensCount % 4;

        if (remainder == 0) {
            return 3;
        } else if (remainder == 3) {
            return 2;
        } else if (remainder == 2) {
            return 1;
        }

        return 1;
    }

    private static boolean isInLosingPosition(int pensCount) {
        return pensCount % 4 == 1;
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
                    setTheOtherPlayerAsBot(index, players);
                    return index;
                }
            }
        }
    }

    private static void setTheOtherPlayerAsBot(int playerIndex, List<Player> players) {
        Player bot = players.get((playerIndex + 1) % players.size());
        bot.setBot(true);
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
        private boolean isBot;

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

        public boolean isBot() {
            return isBot;
        }

        public void setBot(boolean bot) {
            isBot = bot;
        }
    }
}
