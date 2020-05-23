package com.dongheon.laddergame.domain.ladder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 사다리_결과_테스트() {
        // given
        List<Line> specifiedLines = Arrays.asList(
                new Line(Arrays.asList(true, false, true, false))
        );
        Ladder specifiedLadder = new Ladder(specifiedLines);

        // when
        List<Integer> result = specifiedLadder.getResult();

        // then
        assertThat(result).isEqualTo(Arrays.asList(1, 0, 3, 2));
    }
}