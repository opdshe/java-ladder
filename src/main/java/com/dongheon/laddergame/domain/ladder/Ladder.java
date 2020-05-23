package com.dongheon.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Integer> getResult() {
        List<Integer> result = new ArrayList<>();
        int countOfUser = lines.get(0).getSize();
        for (int userIdx = 0; userIdx < countOfUser; userIdx++) {
            int optionIdx = getOptionIdx(userIdx);
            result.add(optionIdx);
        }
        return result;
    }

    private int getOptionIdx(int column) {
        int currentRow = 0;
        int maxHeight = getMaxHeight();
        while (currentRow < getMaxHeight()) {
            column = getLine(currentRow).positionAfterMove(column);
            currentRow++;
        }
        return column;
    }

    public Line getLine(int row) {
        return lines.get(row);
    }

    public int getMaxHeight() {
        return lines.size();
    }
}
