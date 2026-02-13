package _04_StreamFilesAndDirectories;

import java.io.*;
import java.util.*;

public class L02_WriteToFile {

/*Read the file named "input.txt" that is provided for this exercise and write all its content to a file while skipping any punctuation.
Skip the following symbols: ",", ".", "!", "?".*/

    public static void main(String[] args) {

        String pathIn = "input.txt";
        String pathOut = "output.txt";
        ArrayList<Character> forbiddenSymbols = new ArrayList<>();
        Collections.addAll( forbiddenSymbols, ',', '.', '!', '?');

        try (FileInputStream input = new FileInputStream(pathIn); FileOutputStream output = new FileOutputStream(pathOut)){
            int oneByte = input.read();

            while (oneByte >= 0) {
                if (!forbiddenSymbols.contains((char)oneByte)) {
                    output.write(oneByte);
                }
                System.out.print(oneByte);
                oneByte = input.read();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
