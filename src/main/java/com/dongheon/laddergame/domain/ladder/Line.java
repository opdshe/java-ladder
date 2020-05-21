package com.dongheon.laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
