package com.dongheon.laddergame.domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderCreatorTest {
    @Test
    public void Ladder_생성_테스트() {
        // given
        int countOfUser = 4;
        int maxHeight = 5;
        Ladder ladder = LadderCreator.createLadder(countOfUser, maxHeight);
        // when
        int row = ladder.getMaxHeight();
        int column = ladder.getLine(0).getSize();
        // then
        assertThat(row).isEqualTo(maxHeight);
        assertThat(column).isEqualTo(countOfUser);
    }

}