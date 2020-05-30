package com.dongheon.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {

    public static Ladder createLadder(int countOfUser, int maxHeight, LineCreateStrategy strategy) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < maxHeight; i++) {
            Line line = LineCreator.createLine(countOfUser, strategy);
            ladder.add(line);
        }
        return new Ladder(ladder);
    }
}
