package com.dongheon.laddergame.domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineCreatorTest {
    @Test
    public void createLine_테스트() {
        // given
        int countOfUser = 4;
        // when
        Line line = LineCreator.createLine(4);
        // then
        assertThat(line.getPoints().size()).isEqualTo(countOfUser);
    }
}