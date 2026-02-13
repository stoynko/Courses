package Projects.Readability_Score;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_Score {

/*In this stage, you will program the Automated readability index (ARI). It was introduced in 1968 and a lot of research works rely on this.
The index is calculated by the following formula:

score = 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43

Below you can see the table that specifies the age brackets.

  ┌───────┬───────┬──────────────┬───────┬───────┬────────────────┐
  │ Score │  Age   │ Grade Level  │ Score │  Age  │  Grade Level    │
  ├───────┼───────┼──────────────┼───────┼───────┼────────────────┤
  │   1   │  5-6   │ Kindergarten │   8   │ 12-13 │ Seventh Grade  │
  ├───────┼───────┼──────────────┼───────┼───────┼────────────────┤
  │   2   │  6-7  │ First Grade  │   9   │ 13-14 │ Eighth Grade   │
  ├───────┼───────┼──────────────┼───────┼───────┼────────────────┤
  │   3   │  7-8  │ Second Grade │  10   │ 14-15 │ Ninth Grade    │
  ├───────┼───────┼──────────────┼───────┼───────┼────────────────┤
  │   4   │  8-9  │ Third Grade  │  11   │ 15-16 │ Tenth Grade    │
  ├───────┼───────┼──────────────┼───────┼───────┼────────────────┤
  │   5   │  9-10 │ Fourth Grade │  12   │ 16-17 │ Eleventh Grade │
  ├───────┼───────┼──────────────┼───────┼───────┼────────────────┤
  │   6   │ 10-11 │ Fifth Grade  │  13   │ 17-18 │ Twelfth Grade  │
  ├───────┼───────┼──────────────┼───────┼───────┼────────────────┤
  │   7   │ 11-12 │ Sixth Grade  │  14   │ 18-22 │ College student│
  └───────┴───────┴──────────────┴───────┴───────┴────────────────┘

Also, your program should read a file instead of typing a text manually. You should pass the filename through the command line arguments.
The program should output the score itself and an approximate age needed to comprehend the text.
Use the appropriate rounding function to calculate the score as integer.You should also print how many characters, words, and sentences the text has.
The number of characters is any visible symbol (so, in the real text it's everything except space, newline "\n" and tab "\t").
Notice, that the text can contain multiple lines, not just a single line like in the previous stages. You should analyze all the lines.

Example
> java Main in.txt
The text is:
Readability is the ease with which a reader can understand a written text. In natural language, the readability of text depends on its content and its presentation. Researchers have used various factors to measure readability. Readability is more than simply legibility, which is a measure of how easily a reader can distinguish individual letters or characters from each other. Higher readability eases reading effort and speed for any reader, but it is especially important for those who do not have high reading comprehension. In readers with poor reading comprehension, raising the readability level of a text from mediocre to good can make the difference between success and failure

Words: 108
Sentences: 6
Characters: 580
The score is: 12.86
This text should be understood by 17-18 year-olds. */

    public static final String WORDS = "Words: ";
    public static final String SENTENCES = "Sentences: ";
    public static final String CHARACTERS = "Characters: ";
    public static final String SCORE_OUTPUT = "The score is: %.2f";
    public static final String UNDERSTANDING_LEVEL_OUTPUT = "This text should be understood by %s year-olds.";
    public static final List<String> AGE_RANGERS = Arrays.asList("5-6", "6-7", "7-8", "8-9", "9-10", "10-11", "11-12", "12-13",
                                                                 "13-14", "14-15", "15-16", "16-17", "17-18", "18-22");

    public static final String REGEX_SENTENCE = "[^.!?]+[.!?]|[^.!?]+$";
    public static final String REGEX_CHARACTER = "[^\\s\\t\\n]";

    public static void main(String[] args) throws IOException {

        String input = readFileAsString(args[0]);

        Matcher sentenceMatcher = Pattern.compile(REGEX_SENTENCE).matcher(input);
        Matcher characterMatcher = Pattern.compile(REGEX_CHARACTER).matcher(input);

        int sentencesCount = getElementsCount(sentenceMatcher, input);
        int wordsCount = input.split("\\s+").length;
        int charactersCount = getElementsCount(characterMatcher, input);

        double score = 4.71 * ((double) charactersCount / wordsCount) + 0.5 * ((double) wordsCount / sentencesCount) - 21.43;
        score = Math.floor(score * 100.0) / 100.0;

        System.out.println(WORDS + wordsCount);
        System.out.println(SENTENCES + sentencesCount);
        System.out.println(CHARACTERS + charactersCount);
        System.out.println(SCORE_OUTPUT.formatted(score));
        System.out.println(UNDERSTANDING_LEVEL_OUTPUT.formatted(AGE_RANGERS.get((int)Math.ceil(score) - 1)));
    }

    private static int getElementsCount(Matcher matcher, String input) {

        int elementsCount = 0;
        while (matcher.find()) {
            elementsCount++;
        }

        return elementsCount;
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
