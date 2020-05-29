package com.dongheon.laddergame.domain.ladder;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Line getLine(int row) {
        return lines.get(row);
    }

    public int getMaxHeight() {
        return lines.size();
    }
}
