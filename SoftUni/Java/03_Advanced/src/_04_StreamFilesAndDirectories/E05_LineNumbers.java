package _04_StreamFilesAndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class E05_LineNumbers {

/*Write a program that reads a text file ("inputLineNumbers.txt" from the Resources - Exercises) and inserts line numbers in front of each of its lines.
The result should be written to another text file – "output.txt". */

    public static void main(String[] args) throws IOException {

        String pathIn = "inputLineNumbers.txt";
        String pathOut = "output.txt";

        List<String> lines = Files.readAllLines(Path.of(pathIn));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathOut));

        int count = 1;
        for (String line : lines) {
            bufferedWriter.write(count + ". " + line);
            bufferedWriter.newLine();
            count++;
        }
        bufferedWriter.close();
    }
}
