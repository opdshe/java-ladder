package com.dongheon.laddergame.exceptions;

public class EmptyInputException extends Exception {
    private static final String MESSAGE = "입력값이 빈 문자열입니다. 다시 입력해 주세요. ";

    public EmptyInputException() {
        super(MESSAGE);
    }
}
