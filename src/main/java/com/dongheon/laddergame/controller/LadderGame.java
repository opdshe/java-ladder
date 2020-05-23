package com.dongheon.laddergame.controller;

import com.dongheon.laddergame.View.InputView;
import com.dongheon.laddergame.View.OutputView;
import com.dongheon.laddergame.domain.GameResult;
import com.dongheon.laddergame.domain.ladder.Ladder;
import com.dongheon.laddergame.domain.ladder.LadderCreator;
import com.dongheon.laddergame.exceptions.IsNotInUserNamesException;

import java.util.List;
import java.util.Scanner;

public class LadderGame {
    public static final int MAXIMUM_USER_NAME_LENGTH = 5;
    public static final String SHOW_EVERYONE = "all";
    private static final String WHOSE_RESULT_DO_YOU_WANT = "결과를 보고 싶은 사람은?";

    private static Scanner scanner = new Scanner(System.in);

    public static void play() throws IsNotInUserNamesException {
        List<String> userNames = InputView.getUserNames();
        List<String> options = InputView.getOptions(userNames.size());
        int maxHeight = InputView.getMaxHeight();

        Ladder ladder = LadderCreator.createLadder(userNames.size(), maxHeight);
        OutputView.printResult(ladder, userNames, options);
        GameResult gameResult = new GameResult(ladder.getResult(), userNames, options);

        showResult(gameResult);
    }

    private static void showResult(GameResult gameResult) {
        String input;
        do {
            OutputView.printMessage("\n" + WHOSE_RESULT_DO_YOU_WANT);
            input = scanner.nextLine();
            OutputView.printMessage("\n실행결과");
            String result = getResult(gameResult, input);
            OutputView.printMessage(result);
        } while (!input.equals(SHOW_EVERYONE));
    }

    private static String getResult(GameResult gameResult, String input) {
        String result;
        try {
            result = gameResult.getOption(input);
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
}
