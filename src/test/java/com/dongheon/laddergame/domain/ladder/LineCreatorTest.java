package com.dongheon.laddergame.domain.ladder;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineCreatorTest {
    @Test
    public void Line_생성_테스트() {
        // given
        int countOfUser = 4;

        // when
        Line line = new Line(Arrays.asList(true, false, true, false));
        Line createdByLineCreator = LineCreator.createLine(countOfUser, new SpecifyCreateStrategy());

        // then
        assertThat(line).isEqualTo(createdByLineCreator);
    }
}