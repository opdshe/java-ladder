package com.dongheon.laddergame.exceptions;

public class IsNotSameWithCountOfUserException extends Exception {
    private static final String MESSAGE = "옵션의 수가 사용자 수와 일치하지 않습니다. ";

    public IsNotSameWithCountOfUserException() {
        super(MESSAGE);
    }
}
