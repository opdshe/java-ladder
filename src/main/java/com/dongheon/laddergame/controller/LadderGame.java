package com.dongheon.laddergame.controller;

import com.dongheon.laddergame.View.InputView;
import com.dongheon.laddergame.domain.ladder.Ladder;
import com.dongheon.laddergame.domain.ladder.LadderCreator;

import java.util.List;

public class LadderGame {

    public static void play() {
        List<String> userNames = InputView.getUserNames();
        List<String> options = InputView.getOptions(userNames.size());
        int maxHeight = InputView.getMaxHeight();
        Ladder ladder = LadderCreator.createLadder(userNames.size(), maxHeight);
        
    }
}
