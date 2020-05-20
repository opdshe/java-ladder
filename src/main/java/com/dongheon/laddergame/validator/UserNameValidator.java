package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.domain.User;
import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.utils.ExceptionDetector;
import com.dongheon.laddergame.exceptions.IllegalNameLengthException;

import java.util.List;
import java.util.function.Predicate;

public class UserNameValidator {
    public static void test(List<String> userNames) throws Exception {
        ExceptionDetector.throwException(new EmptyInputException(), userNames, List::isEmpty);
        ExceptionDetector.throwException(new IllegalNameLengthException(), userNames, IncorrectLengthPredicate);
    }


    private static Predicate<List<String>> IncorrectLengthPredicate = (userName) -> userName.stream()
            .anyMatch(UserNameValidator::InCorrectLength);

    private static boolean InCorrectLength(String name) {
        return name.length() < User.MIN_USER_NAME || name.length() > User.MAX_NAME_LENGTH;
    }



}


