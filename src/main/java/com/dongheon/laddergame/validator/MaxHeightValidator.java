package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.IsNotOverZeroException;
import com.dongheon.laddergame.exceptions.ExceptionDetector;

public class MaxHeightValidator {
    private static final int MINIMUM_HEIGHT = 1;

    public static void validate(int maxHeight) throws Exception {
        ExceptionDetector.throwException(new IsNotOverZeroException("최대 높이는 1이상으로 입력해 주세요. "),
                maxHeight, height -> height < MINIMUM_HEIGHT);
    }
}
