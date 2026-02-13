package _04_StreamFilesAndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class L06_SortLines {

//Read the file provided, named "input.txt" and sort all lines. Write text to another text file. Use Path and Files Classes.

    public static void main(String[] args) throws IOException {

        String pathIn = "input.txt";
        String pathOut = "SortLinesOutput.txt";

        Path input = Paths.get(pathIn);
        Path output = Paths.get(pathOut);

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        Files.write(output, lines);
    }
}
