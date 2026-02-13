package Projects.Readability_Score;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_Words_And_Sentences {

/* Description
However, a real text may be pretty long and still easy to read, right? There needs to be another approach.
How about calculating the number of words in each sentence? Clearly, if each sentence of a text contains a lot of words,
this text is hard to read. Suppose that if the text contains sentences that on average have more than 10 words per sentence,
this text is hard to read. Otherwise, this text is easy to read. Don't worry, we will consider more scientific ways in the next stages.

The input contains a single line of text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.

For example, the first example contains two sentences with 6 and 10 words (numbers also count as words) so the average is 8, and this is less than 10.
In the second example, there are also 2 sentences but with 6 and 16 words, so the average is 11 and this is more than 10.
If the average is equal to 10, the text is still considered easy to read.

Don't forget that sentences can end with a full stop as well as with an exclamation mark and a question mark.
But the last sentence can be with or without a punctuation mark at the end. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        Matcher sentenceMatcher = Pattern.compile("[.!?]").matcher(input);
        Matcher wordMatcher = Pattern.compile("[^\\s,!.?]+").matcher(input);

        int sentenceCount = 0;
        while (sentenceMatcher.find()) {
            sentenceCount++;
        }

        if (sentenceCount == 0) {
            sentenceCount = 1;
        }

        int wordCount = 0;
        while (wordMatcher.find()) {
            wordCount++;
        }

        double average = (double) wordCount / sentenceCount;
        System.out.println(average > 10 ? "HARD" : "EASY");
    }
}
