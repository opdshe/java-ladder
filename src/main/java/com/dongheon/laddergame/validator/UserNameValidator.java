package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.controller.LadderGame;
import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.exceptions.ExceptionDetector;
import com.dongheon.laddergame.exceptions.IncorrectNameLengthException;

import java.util.List;
import java.util.function.Predicate;

public class UserNameValidator {
    private static final int MINIMUM_USER_NAME_LENGTH = 1;

    public static void validate(List<String> userNames) throws Exception {
        ExceptionDetector.throwException(new EmptyInputException(), userNames, List::isEmpty);
        ExceptionDetector.throwException(new IncorrectNameLengthException(), userNames, incorrectLengthPredicate);
    }

    private static Predicate<List<String>> incorrectLengthPredicate = (userName) -> userName.stream()
            .anyMatch(UserNameValidator::inCorrectLength);

    private static boolean inCorrectLength(String name) {
        return name.length() < MINIMUM_USER_NAME_LENGTH || name.length() > LadderGame.MAXIMUM_USER_NAME_LENGTH;
    }
}


