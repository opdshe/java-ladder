package com.dongheon.laddergame.validator;

import java.util.List;

public class Validator {
    private static final int ZERO = 0;

    public static void validateOptions(List<String> convertedNames) {
        long countOfWin = convertedNames.stream()
                .filter(Validator::isNumeric)
                .count();
        if (countOfWin <= ZERO) {
            throw new IllegalArgumentException("당첨 옵션은 최소 하나 이상으로 설정해주세요. ");
        }
    }

    public static void validateHeight(String height) {
        if (!isNumeric(height) || !isOverZero(Integer.parseInt(height))) {
            throw new IllegalArgumentException("높이는 1이상의 정수로 입력해주세요. ");
        }
    }

    private static boolean isNumeric(String s) {
        return s.matches("\\d+");
    }

    private static boolean isOverZero(int count) {
        return count > ZERO;
    }
}
