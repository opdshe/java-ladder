package com.dongheon.laddergame.domain.ladder;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 다리가_오른쪽으로_연결되어_있을_경우() {
        // given
        Line line = new Line(Arrays.asList(false, true, false));
        int current = 1;
        // when
        int nextColumn = line.getPositionAfterMove(current);
        // then
        assertThat(nextColumn).isEqualTo(current + 1);
    }

    @Test
    public void 다리가_왼쪽으로_연결되어_있을_경우() {
        // given
        Line line = new Line(Arrays.asList(false, true, false));
        int current = 2;
        // when
        int nextColumn = line.getPositionAfterMove(current);
        // then
        assertThat(nextColumn).isEqualTo(current - 1);
    }

    @Test
    public void 양_옆_모두_갈_수_없는_경우() {
        // given
        Line line = new Line(Arrays.asList(false, false, false));
        int current = 1;
        // when
        int nextColumn = line.getPositionAfterMove(current);
        // then
        assertThat(nextColumn).isEqualTo(current);
    }

}