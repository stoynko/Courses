package _011_Eleventh_Day_Of_Coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Eleventh_Day_Of_Coding {

    public static void main(String[] args) {



    }

    public static List<String> getInputData() throws IOException {
        String[] input = Files.readString(Path.of("/Users/yani/Development/Repositories/Hyperskill-Courses/12_Days_Of_Coding/src/_011_Eleventh_Day_Of_Coding/resources/hyperskill-dataset-119207458.txt")).split("\n");

        List<String> inputData = new ArrayList<>();

        for (int index = 0; index < input.length; index++) {
            String sequence = input[index].replace(",", "");
            inputData.add(sequence);

        }

        inputData.sort(Comparator.comparingInt(String::length));
        return inputData;
    }
}
