package Projects.Readability_Score;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_More_Parameters {

    public static final String WORDS = "Words: ";
    public static final String SENTENCES = "Sentences: ";
    public static final String CHARACTERS = "Characters: ";
    public static final String SYLLABLES = "Syllables: ";
    public static final String POLYSYLLABLES = "Polysyllables: ";
    public static final String INPUT_PROMPT = "Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ";
    public static final String ARI_OUTPUT = "Automated Readability Index: %.2f (about %d-year-olds).";
    public static final String FKR_OUTPUT = "Flesch–Kincaid readability tests: %.2f (about %d-year-olds).";
    public static final String SMOG_OUTPUT = "Simple Measure of Gobbledygook: %.2f (about %d-year-olds).";
    public static final String CL_INDEX = "Coleman–Liau index: %.2f (about %d-year-olds).";
    public static final String UNDERSTANDING_LEVEL_OUTPUT =
            "This text should be understood in average by %.2f-year-olds";

    public static final String REGEX_SENTENCE = "[^.!?]+[.!?]|[^.!?]+$";
    public static final String REGEX_CHARACTER = "[^\\s\\t\\n]";

    public static void main(String[] args) throws IOException {

        String input = readFileAsString(args[0]);
        Matcher sentenceMatcher = Pattern.compile(REGEX_SENTENCE).matcher(input);
        Matcher characterMatcher = Pattern.compile(REGEX_CHARACTER).matcher(input);
        Scanner scanner = new Scanner(System.in);

        int sentencesCount = getElementsCount(sentenceMatcher);
        int wordsCount = input.split("\\s+").length;
        int charactersCount = getElementsCount(characterMatcher);
        int syllablesCount = getSyllablesCount(input);
        int polysyllablesCount = getPolysyllablesCount(input);

        double ariIndex = calculateAriIndex(sentencesCount, wordsCount, charactersCount);
        double fkrIndex = calculateFKindex(sentencesCount, wordsCount, syllablesCount);
        double smogIndex = calculateSmogIndex(sentencesCount, polysyllablesCount);
        double clIndex = calculateCLIndex(sentencesCount, wordsCount, charactersCount);

        System.out.println("The text is:");
        System.out.println(input);
        System.out.println(WORDS + wordsCount);
        System.out.println(SENTENCES + sentencesCount);
        System.out.println(CHARACTERS + charactersCount);
        System.out.println(SYLLABLES + syllablesCount);
        System.out.println(POLYSYLLABLES + polysyllablesCount);
        System.out.print(INPUT_PROMPT);

        String userInput = scanner.nextLine();
        System.out.println();

        switch (userInput) {
            case "ARI" -> System.out.println(ARI_OUTPUT.formatted(ariIndex, getAge(ariIndex)));
            case "FK" -> System.out.println(FKR_OUTPUT.formatted(fkrIndex, getAge(fkrIndex)));
            case "SMOG" -> System.out.println(SMOG_OUTPUT.formatted(smogIndex, getAge(smogIndex)));
            case "CL" -> System.out.println(CL_INDEX.formatted(clIndex, getAge(clIndex)));
            case "all" -> {
                System.out.println(ARI_OUTPUT.formatted(ariIndex, getAge(ariIndex)));
                System.out.println(FKR_OUTPUT.formatted(fkrIndex, getAge(fkrIndex)));
                System.out.println(SMOG_OUTPUT.formatted(smogIndex, getAge(smogIndex)));
                System.out.println(CL_INDEX.formatted(clIndex, getAge(clIndex)));
                System.out.println();

                double averageLevel = calculateAverageUnderstandingLevel(ariIndex, fkrIndex, smogIndex, clIndex);
                System.out.println(UNDERSTANDING_LEVEL_OUTPUT.formatted(averageLevel));
            }
        }
    }

    private static int getAge(double score) {
        int grade = (int) Math.ceil(score);

        if (grade <= 1) return 6;
        if (grade >= 14) return 22;

        return grade + 5;
    }

    private static double calculateAverageUnderstandingLevel(double ariIndex, double fkrIndex, double smogIndex, double clIndex) {

        int sum = getAge(ariIndex) + getAge(fkrIndex) + getAge(smogIndex) + getAge(clIndex);
        return sum / 4.0;
    }

    private static double calculateCLIndex(int sentencesCount, int wordsCount, int charactersCount) {
        double l = ((double) charactersCount / wordsCount) * 100;
        double s = ((double) sentencesCount / wordsCount) * 100;
        return Math.floor((0.0588 * l - 0.296 * s - 15.8) * 100) / 100.0;
    }

    private static double calculateSmogIndex(int sentencesCount, int polysyllablesCount) {
        return Math.floor((1.043 * Math.sqrt(polysyllablesCount * (30.0 / sentencesCount)) + 3.1291) * 100) / 100.0;
    }

    private static double calculateFKindex(int sentencesCount, int wordsCount, int syllablesCount) {
        return Math.floor((0.39 * ((double) wordsCount / sentencesCount) + 11.8 * ((double) syllablesCount / wordsCount) - 15.59) * 100) / 100.0;
    }

    private static double calculateAriIndex(int sentencesCount, int wordsCount, int charactersCount) {
        return Math.floor((4.71 * ((double) charactersCount / wordsCount) + 0.5 * ((double) wordsCount / sentencesCount) - 21.43) * 100) / 100.0;
    }

    private static int getPolysyllablesCount(String input) {
        String[] words = input.split("\\s+");
        int count = 0;

        for (String word : words) {
            if (getSyllablesForWord(word) > 2) {
                count++;
            }
        }
        return count;
    }

    private static int getSyllablesCount(String input) {
        String[] words = input.split("\\s+");
        int total = 0;

        for (String word : words) {
            total += getSyllablesForWord(word);
        }
        return total;
    }

    private static int getSyllablesForWord(String word) {
        word = word.toLowerCase().replaceAll("^[^a-z]+|[^a-z]+$", "");
        int vowelsCount = word.replaceAll("[aeiouy]{2,}", "a")
                .replaceAll("e$", "")
                .replaceAll("[^aeiouy]", "")
                .length();

        return Math.max(1, vowelsCount);
    }

    private static int getElementsCount(Matcher matcher) {
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}

