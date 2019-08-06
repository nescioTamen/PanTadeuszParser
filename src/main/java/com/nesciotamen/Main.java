package com.nesciotamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static com.nesciotamen.Reader.readFile;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("src/main/resources/pan-tadeusz.txt");
        String textPanTadeusz = readFile(textFile);

        System.out.println("Number of occurrences of words sorted by quantity descending: ");
        List<Map.Entry<String, Long>> occurrencesByQuantity = Parser.occurrencesByQuantity(textPanTadeusz);
        occurrencesByQuantity.forEach(linia -> System.out.println(linia.getKey() + " - " + linia.getValue()));

        System.out.println("The number of words that occur only once: ");
        System.out.println(Parser.theNumberOfWordsThatOccurOnlyOnce(textPanTadeusz));
    }
}
