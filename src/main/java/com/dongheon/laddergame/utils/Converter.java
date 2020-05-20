package com.dongheon.laddergame.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<String> stringToList (String string) {
        return Arrays.stream(string.split(","))
                .map(String::trim)
                .filter(s->!s.isEmpty())
                .collect(Collectors.toList());
    }
}
