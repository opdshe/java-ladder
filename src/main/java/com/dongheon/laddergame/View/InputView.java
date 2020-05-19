package com.dongheon.laddergame.View;

import com.dongheon.laddergame.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표 (,)로 구분하세요";
    private static final String INPUT_OPTIONS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요. ";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";


    private Scanner scanner = new Scanner(System.in);

    public List<String> getParticipantsNames() {
        OutputView.printMessage(INPUT_PARTICIPANTS_NAME);
        String participantsNames = scanner.nextLine();
        return Arrays.stream(participantsNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> getOptions() {
        OutputView.printMessage(INPUT_OPTIONS);
        String options = scanner.nextLine();
        List<String> convertedNames = Arrays.stream(options.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        try {
            Validator.validateOptions(convertedNames);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getOptions();
        }
        return convertedNames;
    }

    public int getHeight() {
        OutputView.printMessage(INPUT_HEIGHT);
        String height = scanner.nextLine();
        try {
            Validator.validateHeight(height);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getHeight();
        }
        return Integer.parseInt(height);
    }
}
