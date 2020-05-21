package com.dongheon.laddergame.exceptions;

public class ContinuedTrueException extends Exception {
    private static final String MESSAGE = "한 라인에서 연속된 다리를 생성할 수 없습니다. ";

    public ContinuedTrueException() {
        super(MESSAGE);
    }
}
