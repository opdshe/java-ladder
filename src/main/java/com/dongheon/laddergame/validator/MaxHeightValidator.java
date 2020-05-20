package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.IncorrectCountOfHeightException;
import com.dongheon.laddergame.utils.ExceptionDetector;

public class MaxHeightValidator {
    private static final int MINIMUM_HEIGHT = 1;

    public static void test(int maxHeight) throws Exception {
        ExceptionDetector.throwException(new IncorrectCountOfHeightException(), maxHeight, height -> height < MINIMUM_HEIGHT);
    }
}
