package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.exceptions.IncorrectCountOfPrizeException;
import com.dongheon.laddergame.utils.ExceptionDetector;

import java.util.List;
import java.util.function.Predicate;

public class OptionValidator {
    private static final int MINIMUM_COUNT_OF_PRIZE = 1;

    public static void test(List<String> options) throws Exception {
        ExceptionDetector.throwException(new EmptyInputException(), options, List::isEmpty);
        ExceptionDetector.throwException(new IncorrectCountOfPrizeException(), options, IncorrectCountOfPrizePredicate);
    }

    private static Predicate<List<String>> IncorrectCountOfPrizePredicate = (options) -> {
        long countOfPrize = options.stream()
                .filter(OptionValidator::isNumeric)
                .count();
        return countOfPrize < MINIMUM_COUNT_OF_PRIZE;
    };

    private static boolean isNumeric(String s) {
        return s.matches("\\d+");
    }
}
