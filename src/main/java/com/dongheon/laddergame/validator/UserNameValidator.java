package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.domain.User.User;
import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.utils.ExceptionDetector;
import com.dongheon.laddergame.exceptions.IncorrectNameLengthException;

import java.util.List;
import java.util.function.Predicate;

public class UserNameValidator {

    public static void validate(List<String> userNames) throws Exception {
        ExceptionDetector.throwException(new EmptyInputException(), userNames, List::isEmpty);
        ExceptionDetector.throwException(new IncorrectNameLengthException(), userNames, incorrectLengthPredicate);
    }

    private static Predicate<List<String>> incorrectLengthPredicate = (userName) -> userName.stream()
            .anyMatch(UserNameValidator::inCorrectLength);

    private static boolean inCorrectLength(String name) {
        return name.length() < User.MIN_USER_NAME || name.length() > User.MAX_NAME_LENGTH;
    }
}


