package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.domain.User;
import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.exceptions.ExceptionDetector;
import com.dongheon.laddergame.exceptions.IllegalNameLengthException;

import java.util.List;

public class UserNameValidator {
    public static void test(List<String> userNames) throws Exception {
        if (userNames.isEmpty()) {
            throw new EmptyInputException();
        }
        ExceptionDetector.detectException(new IllegalNameLengthException(), userNames, UserNameValidator::isCorrectLength);
    }

    private static boolean isCorrectLength(String name) {
        return name.length() >= User.MIN_USER_NAME && name.length() <= User.MAX_NAME_LENGTH;
    }
}
