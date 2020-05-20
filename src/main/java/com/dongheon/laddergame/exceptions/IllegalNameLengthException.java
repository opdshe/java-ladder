package com.dongheon.laddergame.exceptions;

import com.dongheon.laddergame.domain.User;

public class IllegalNameLengthException extends Exception {
    private static final String MESSAGE = "사용자 이름은 " + User.MIN_USER_NAME + "~" +User.MAX_NAME_LENGTH + "글자 사이로 입력해 주세요 ";

    public IllegalNameLengthException() {
        super(MESSAGE);
    }
}
