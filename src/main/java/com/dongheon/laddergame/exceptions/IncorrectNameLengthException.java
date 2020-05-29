package com.dongheon.laddergame.exceptions;

import com.dongheon.laddergame.controller.LadderGame;

public class IncorrectNameLengthException extends RuntimeException {
    private static final String MESSAGE = "사용자 이름은 " + LadderGame.MAXIMUM_USER_NAME_LENGTH + "글자 이하로 입력해 주세요. ";

    public IncorrectNameLengthException() {
        super(MESSAGE);
    }
}
