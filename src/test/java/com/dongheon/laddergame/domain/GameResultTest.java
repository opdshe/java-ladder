package com.dongheon.laddergame.domain;

import com.dongheon.laddergame.exceptions.IsNotInUserNamesException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameResultTest {

    @Test
    public void 해당_사용자_없으면_예외발생() {
        // given
        List<Integer> mockLadderResult = Arrays.asList(2, 1, 0);
        List<String> mockUserNames = Arrays.asList("lee", "hwang", "jung");
        List<String> mockOptions = Arrays.asList("꽝", "꽝", "3500");
        GameResult gameResult = new GameResult(mockLadderResult, mockUserNames, mockOptions);

        // then
        assertThatExceptionOfType(IsNotInUserNamesException.class)
                .isThrownBy(() -> gameResult.getOption("hanzo"));
    }

    @Test
    public void 해당_사용자_있으면_아이템_출력() throws IsNotInUserNamesException {
        // given
        List<Integer> mockLadderResult = Arrays.asList(2, 1, 0);
        List<String> mockUserNames = Arrays.asList("lee", "hwang", "jung");
        List<String> mockOptions = Arrays.asList("꽝", "꽝", "3500");
        GameResult gameResult = new GameResult(mockLadderResult, mockUserNames, mockOptions);

        // when
        String option = gameResult.getOption("lee");

        // then
        assertThat(option).isEqualTo("3500");
    }

    @Test
    public void all_입력_시_전체_출력() throws IsNotInUserNamesException {
        // given
        List<Integer> mockLadderResult = Arrays.asList(2, 1, 0);
        List<String> mockUserNames = Arrays.asList("lee", "hwang", "jung");
        List<String> mockOptions = Arrays.asList("꽝", "꽝", "3500");
        GameResult gameResult = new GameResult(mockLadderResult, mockUserNames, mockOptions);

        // when
        String option = gameResult.getOption("all");

        // then
        assertThat(option)
                .contains("lee")
                .contains("hwang")
                .contains("jung");
    }
}