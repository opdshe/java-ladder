package com.dongheon.laddergame.domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineCreatorTest {
    @Test
    public void Line_생성_테스트() {
        // given
        int countOfUser = 4;
        // when
        Line line = LineCreator.createLine(4);
        // then
        assertThat(line.getLine().size()).isEqualTo(countOfUser);
    }
}