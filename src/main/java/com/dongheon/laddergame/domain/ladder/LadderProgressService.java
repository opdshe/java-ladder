package com.dongheon.laddergame.domain.ladder;

import com.dongheon.laddergame.domain.Calculator;
import com.dongheon.laddergame.domain.GameResult;

import java.util.List;

public class LadderProgressService {
    public static GameResult progress(Ladder ladder, List<String> userNames, List<String> items) {
        return new GameResult(Calculator.calculate(ladder, userNames, items));
    }
}
