package _03_Third_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Third_Day_Of_Coding {

/*On the third day of coding my team lead sent to me... Three security rules,

Two pointers, and a nasty bug in a production tree!

Mr. Frost is quite sad today. The reindeer system got hacked. Apparently, Rudolph had rednose set as his password.
Was not hard to break at all! The cybersecurity team developed a new system where each reindeer has to come up with 50 different passwords,
out of which the tech team will choose the best one on a set of three rules.

Oh, and by "the tech team" they mean you. Good luck!

Input: list of 50 passwords chosen by reindeer, each on a new line
Output: A password with the highest security score based on three rules. In case of ties, the earlier password in the file takes precedence.

The three rules:
- Base password security score is its length.
= Every password should have at least: one lowercase letter, one uppercase letter, one digit, one special symbol (!@#$%^&*).
- If any of these categories are missing, multiply base score by 0.75 for each missing category.
- Every password should minimize repeated characters. If at least 30% of password consists of the same character,
subtract the number of occurrences of that character from the score (applied only to the most frequent character).

Rules are applied sequentially.*/

    public static final String LOWERCASE_REGEX = "[a-z]";
    public static final String UPPERCASE_REGEX = "[A-Z]";
    public static final String DIGIT_REGEX = "[0-9]";
    public static final String SPECIAL_SYMBOL_REGEX = "[!@#$%^&*]";

    public static final Pattern LOWERCASE_PATTERN = Pattern.compile(LOWERCASE_REGEX);
    public static final Pattern UPPERCASE_PATTERN = Pattern.compile(UPPERCASE_REGEX);
    public static final Pattern DIGIT_PATTERN = Pattern.compile(DIGIT_REGEX);
    public static final Pattern SPECIAL_SYMBOL_PATTERN = Pattern.compile(SPECIAL_SYMBOL_REGEX);

    public static void main(String[] args) throws IOException {

        String[] inputData = getInputData().split("\n");

        double bestScore = Double.MIN_VALUE;
        String bestPassword = "";

        for (String input : inputData) {

            double score = getScoreAfterCharValidation(input);
            score -= getPenaltyForOccurrenceCheck(input);
            if (score > bestScore) {
                bestScore = score;
                bestPassword = input;
            }
        }
        System.out.println(bestPassword);
    }

    public static String getInputData() throws IOException {
        return Files.readString(Path.of("/Users/yani/Development/Repositories/Hyperskill-Courses/12_Days_Of_Coding/src/On_The_Third_Day_Of_Coding/resources/hyperskill-dataset-119007671.txt"));
    }

    public static double getScoreAfterCharValidation(String input) {

        double baseScore = input.length() * 1.0;

        Matcher lowercaseMatcher = LOWERCASE_PATTERN.matcher(input);
        if (!lowercaseMatcher.find()) {
            baseScore *= 0.75;
        }

        Matcher uppercaseMatcher = UPPERCASE_PATTERN.matcher(input);
        if (!uppercaseMatcher.find()) {
            baseScore *= 0.75;
        }

        Matcher digitMatcher = DIGIT_PATTERN.matcher(input);
        if (!digitMatcher.find()) {
            baseScore *= 0.75;
        }

        Matcher specialSymbolMatcher = SPECIAL_SYMBOL_PATTERN.matcher(input);
        if (!specialSymbolMatcher.find()) {
            baseScore *= 0.75;
        }

        return baseScore;
    }

    public static double getPenaltyForOccurrenceCheck(String input) {
        Map<Character, Integer> characterMap = getCharacterCount(input);

        int maxCount = 0;
        for (int cnt : characterMap.values()) {
            maxCount = Math.max(maxCount, cnt);
        }

        return (maxCount * 100 >= input.length() * 30) ? (double) maxCount : 0.0;
    }

    public static Map<Character, Integer> getCharacterCount(String input) {
        Map<Character, Integer> characterMap = new HashMap<>();

        for (int index = 0; index < input.length(); index++) {
            char character = input.charAt(index);
            if (!characterMap.containsKey(character)) {
                characterMap.put(character, 1);
            } else {
                characterMap.put(character, characterMap.get(character) + 1);
            }
        }
        return characterMap;
    }
}
