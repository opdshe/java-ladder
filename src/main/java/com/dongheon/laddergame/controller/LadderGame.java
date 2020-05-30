package com.dongheon.laddergame.controller;

import com.dongheon.laddergame.View.InputView;
import com.dongheon.laddergame.View.OutputView;
import com.dongheon.laddergame.domain.Calculator;
import com.dongheon.laddergame.domain.GameResult;
import com.dongheon.laddergame.domain.ladder.Ladder;
import com.dongheon.laddergame.domain.ladder.LadderCreator;
import com.dongheon.laddergame.domain.ladder.RandomCreateStrategy;

import java.util.List;
import java.util.Map;

import static com.dongheon.laddergame.domain.GameResult.EMPTY_STRING_FOR_INDICATE_ALL_RESULT;

public class LadderGame {
    public static final int MAXIMUM_USER_NAME_LENGTH = 5;
    public static final String SHOW_EVERYONE = "all";
    private static final String WHOSE_RESULT_DO_YOU_WANT = "결과를 보고 싶은 사람은?";
    private static final String GAME_RESULT = "실행결과";

    public static void play() {
        List<String> userNames = InputView.getUserNames();
        List<String> items = InputView.getItems(userNames.size());
        int maxHeight = InputView.getMaxHeight();

        Ladder ladder = LadderCreator.createLadder(userNames.size(), maxHeight, new RandomCreateStrategy());
        OutputView.printResult(ladder, userNames, items);
        Map<String, String> result = Calculator.calculate(ladder, userNames, items);
        GameResult gameResult = new GameResult(result);

        showResult(gameResult);
    }

    private static void showResult(GameResult gameResult) {
        String result;
        do {
            OutputView.printMessage("\n" + WHOSE_RESULT_DO_YOU_WANT);
            String input = InputView.inputUserName();
            OutputView.printMessage("\n" + GAME_RESULT);
            result = getResult(gameResult, input);
            OutputView.printMessage(result);
        } while (!result.equals(EMPTY_STRING_FOR_INDICATE_ALL_RESULT));
        OutputView.printTotalResult(gameResult);
    }

    private static String getResult(GameResult gameResult, String input) {
        String result;
        try {
            result = gameResult.getMatchedItem(input);
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
}
