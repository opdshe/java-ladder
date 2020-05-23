package com.dongheon.laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Line {
    private final int MINIMUM_COLUMN_FOR_CHECKING_LEFT = 1;

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int positionAfterMove(int column) {
        if (hasLine(column)) {
            return column + 1;
        }
        if (column >= MINIMUM_COLUMN_FOR_CHECKING_LEFT && hasLine(column - 1)) {
            return column - 1;
        }
        return column;
    }

    public boolean hasLine(int column) {
        return points.get(column);
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(points);
    }

    public int getSize() {
        return points.size();
    }
}
