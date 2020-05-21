package com.dongheon.laddergame.View;

import com.dongheon.laddergame.utils.Converter;
import com.dongheon.laddergame.validator.MaxHeightValidator;
import com.dongheon.laddergame.validator.OptionValidator;
import com.dongheon.laddergame.validator.UserNameValidator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표 (,)로 구분하세요";
    private static final String INPUT_OPTIONS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요. ";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private Scanner scanner = new Scanner(System.in);

    public List<String> getUserNames() {
        OutputView.printMessage(INPUT_PARTICIPANTS_NAME);
        String usersNames = scanner.nextLine();
        List<String> converted = Converter.stringToList(usersNames);
        try {
            UserNameValidator.validate(converted);
        } catch (Exception e) {
            OutputView.printMessage(e.getMessage());
            return getUserNames();
        }
        return converted;
    }

    public List<String> getOptions(int countOfUser) {
        OutputView.printMessage(INPUT_OPTIONS);
        String options = scanner.nextLine();
        List<String> converted = Converter.stringToList(options);
        try {
            OptionValidator.validate(converted, countOfUser);
        } catch (Exception e) {
            OutputView.printMessage(e.getMessage());
            return getOptions(countOfUser);
        }
        return converted;
    }

    public int getMaxHeight() {
        OutputView.printMessage(INPUT_HEIGHT);
        int maxHeight = scanner.nextInt();
        try {
            MaxHeightValidator.validate(maxHeight);
        } catch (Exception e) {
            OutputView.printMessage(e.getMessage());
            return getMaxHeight();
        }
        return maxHeight;
    }
}
