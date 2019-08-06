package com.nesciotamen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static List<Map.Entry<String, Long>> occurrencesByQuantity(String string) {
        return getStream(string)
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public static long theNumberOfWordsThatOccurOnlyOnce(String string) {
        return getStream(string)
                .filter(str -> str.getValue() < 2)
                .count();
    }

    private static Stream<Map.Entry<String, Long>> getStream(String string) {
        return Arrays.stream(string.split(" "))
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream();
    }
}
