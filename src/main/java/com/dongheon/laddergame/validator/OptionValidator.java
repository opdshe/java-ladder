package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.exceptions.IsNotOverZeroException;
import com.dongheon.laddergame.exceptions.IsNotSameWithCountOfUserException;
import com.dongheon.laddergame.exceptions.ExceptionDetector;

import java.util.List;
import java.util.function.Predicate;

public class OptionValidator {

    public static void validate(List<String> options, int countOfUser) throws Exception {
        ExceptionDetector.throwException(new EmptyInputException(), options, List::isEmpty);
        ExceptionDetector.throwException(new IsNotSameWithCountOfUserException(), options, (List<String> option)->option.size()!=countOfUser);
        ExceptionDetector.throwException(new IsNotOverZeroException("상금의 개수를 1이상으로 입력해 주세요"),
                options, incorrectCountOfPrizePredicate);
    }

    private static Predicate<List<String>> incorrectCountOfPrizePredicate = (options) -> options.stream()
            .noneMatch(OptionValidator::isNumeric);

    private static boolean isNumeric(String s) {
        return s.matches("\\d+");
    }
}
