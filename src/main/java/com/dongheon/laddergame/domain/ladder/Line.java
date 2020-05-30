package com.dongheon.laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final static int MINIMUM_COLUMN_FOR_CHECKING_LEFT = 1;

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int getPositionAfterMove(int column) {
        if (hasLine(column)) {
            return column + 1;
        }
        if (availableToMoveLeft(column) && hasLine(column - 1)) {
            return column - 1;
        }
        return column;
    }

    public boolean hasLine(int column) {
        return points.get(column);
    }

    private static boolean availableToMoveLeft(int column) {
        return column >= MINIMUM_COLUMN_FOR_CHECKING_LEFT;
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(points);
    }

    public int getSize() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
