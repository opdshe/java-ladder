package com.dongheon.laddergame.exceptions;

public class IncorrectCountOfPrizeException extends Exception {
    private static final String MESSAGE = "상금의 개수가 적어도 하나 이상이어야 합니다. ";

    public IncorrectCountOfPrizeException() {
        super(MESSAGE);
    }
}
