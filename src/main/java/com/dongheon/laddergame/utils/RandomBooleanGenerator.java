package com.dongheon.laddergame.utils;

import java.util.Random;

public class RandomBooleanGenerator {

    public static boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
