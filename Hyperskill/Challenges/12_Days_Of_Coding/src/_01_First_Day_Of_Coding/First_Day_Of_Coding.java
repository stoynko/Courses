package _01_First_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class First_Day_Of_Coding {

/*Welcome to your new job at North Pole Technologies, your best provider of every winter holiday!
As you should already know, we at NPT host a once-in-a-year programming internship, which we've dubbed "Twelve Days of Coding"!
You and your colleagues will tackle 12 challenging tasks, one each day, carefully crafted by our team lead, Mr. Frost!
Only the best performing developers will be able to continue working on our fabulous projects, so don't get too cozy.
Less talking, more grinding! Just follow the lyrics of our theme song!

On the first day of coding my team lead sent to me... One nasty bug in a production tree!

Mr. Frost drops a log file on your desk with a concerned look.
"Our production monitoring system has been going haywire. We've got one error that's basically background noise at this point - happens constantly,
we've learned to live with it. But look at this timeframe: 15:00 to 15:30. Something else went wrong during that timeframe,
and it's getting buried under all the usual noise. I need you to dig through these logs and tell me what error actually spiked during the incident."

You have a log file with entries in the format HH:MM ErrorName.
You need to find and submit the name of the most common error in the logs between 15:00 and 15:30,
excluding the error that is most common throughout the entire day (that's the "background noise" one).*/

    public static void main(String[] args) throws IOException {

        String logInput = Files.readString(Path.of("_01_First_Day_Of_Coding/resource/hyperskill-dataset-118965861.txt"));


        String backgroundNoiseError = getBackgroundNoiseError(logInput);
        String mostEncounteredError = getMostEncounteredErrorInTimeframeExcludingNoise
                (logInput, "15:00", "15:30", backgroundNoiseError);

        System.out.println(mostEncounteredError);
    }

    public static String getBackgroundNoiseError(String logInput) {
        Map<String, Long> errorsOccurrence = stream(logInput.split("\n"))
                .filter(str -> str.length() >= 6)
                .map(str -> str.substring(6).trim())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return errorsOccurrence.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public static String getMostEncounteredErrorInTimeframeExcludingNoise(String logInput, String lowerBound, String upperBound, String backgroundNos) {
        List<String> logArray = stream(logInput.split("\n")).filter(log -> {
            String timeframe = log.substring(0, 5);
            return timeframe.compareTo(lowerBound) >= 0 && timeframe.compareTo(upperBound) <= 0;
        }).collect(Collectors.toList());

        Map<String, Long> errors = logArray.stream()
                .filter(str -> str.length() >= 6)
                .map(str -> str.substring(6).trim())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        return errors.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }
}
