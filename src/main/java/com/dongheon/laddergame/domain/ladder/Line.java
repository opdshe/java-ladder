package com.dongheon.laddergame.domain.ladder;

import com.dongheon.laddergame.validator.LineValidator;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) throws Exception {
        LineValidator.validate(points);
        this.points = points;
    }
}
