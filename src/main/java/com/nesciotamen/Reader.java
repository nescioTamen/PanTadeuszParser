package com.nesciotamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    public static String readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            stringBuilder.append(line.replaceAll("(?:-|[\\[\\]{}()—+/:;!?…»«.,\\\\])", "")).append(" ");
        }

        return stringBuilder.toString();
    }
}
