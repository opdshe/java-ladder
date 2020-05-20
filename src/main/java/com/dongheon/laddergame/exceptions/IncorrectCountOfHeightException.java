package com.dongheon.laddergame.exceptions;

public class IncorrectCountOfHeightException extends Exception {
    private static final String MESSAGE = "최대 높이는 1 이상으로 입력해 주세요 . ";

    public IncorrectCountOfHeightException() {
        super(MESSAGE);
    }
}
