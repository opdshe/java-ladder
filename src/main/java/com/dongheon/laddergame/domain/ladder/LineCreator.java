package com.dongheon.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LineCreator {
    public static Line createLine(int countOfUser, LineCreateStrategy strategy) {
        List<Boolean> line = new ArrayList<>();
        boolean previous = false;
        for (int idx = 0; idx < countOfUser; idx++) {
            boolean point = getPoint(previous, countOfUser, idx, strategy);
            line.add(point);
            previous = point;
        }
        return new Line(line);
    }

    private static boolean getPoint(boolean previous, int countOfUser, int position, LineCreateStrategy strategy) {
        if (!isAvailableToGo(previous, countOfUser, position)) {
            return false;
        }
        return strategy.generate();
    }

    private static boolean isAvailableToGo(boolean previous, int countOfUser, int position) {
        return !previous && position < countOfUser - 1;
    }
}