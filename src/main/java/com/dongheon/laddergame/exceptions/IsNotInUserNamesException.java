package com.dongheon.laddergame.exceptions;

public class IsNotInUserNamesException extends Exception{
    private static final String MESSAGE = "입력하신 이름이 사용자 명단에 존재하지 않습니다. ";

    public IsNotInUserNamesException() {
        super(MESSAGE);
    }
}
