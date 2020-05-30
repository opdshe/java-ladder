package com.dongheon.laddergame.domain.ladder;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderCreatorTest {
    @Test
    public void Ladder_생성_테스트() {
        // given
        int countOfUser = 4;
        int maxHeight = 1;
        Line line = new Line(Arrays.asList(true, false, true, false));
        List<Line> lines = Collections.singletonList(line);

        // when
        Ladder ladder = new Ladder(lines);
        Ladder createdByLadderCreator = LadderCreator.createLadder(countOfUser, maxHeight, new SpecifyCreateStrategy());

        // then
        assertThat(ladder).isEqualTo(createdByLadderCreator);
    }
}