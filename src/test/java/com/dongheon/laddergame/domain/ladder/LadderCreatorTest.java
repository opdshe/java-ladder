package com.dongheon.laddergame.domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderCreatorTest {

    @Test
    public void createLadder_로우_테스트() {
        // given
        int countOfUser = 5;
        int maxHeight = 2;

        // when
        Ladder ladder = LadderCreator.createLadder(countOfUser, maxHeight);
        int countOfRow = ladder.getLines().size();

        // then
        assertThat(countOfRow).isEqualTo(maxHeight);
    }

    @Test
    public void createLadder_칼럼_테스트() {
        // given 
        int countOfUser = 5;
        int maxHeight = 2;

        // when
        Ladder ladder = LadderCreator.createLadder(countOfUser, maxHeight);
        int countOfColumn = ladder.getLines().get(0).getPoints().size();

        // then
        assertThat(countOfColumn).isEqualTo(countOfUser);
    }
}