package com.dongheon.laddergame.domain;

import com.dongheon.laddergame.domain.ladder.Ladder;
import com.dongheon.laddergame.domain.ladder.Line;
import com.dongheon.laddergame.exceptions.IsNotInUserNamesException;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dongheon.laddergame.domain.GameResult.EMPTY_STRING_FOR_INDICATE_ALL_RESULT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameResultTest {

    @Test
    public void 해당_사용자_없으면_예외발생() {
        // given
        Map<String, String> mockResult = new HashMap<>();
        mockResult.put("kim", "꽝");
        mockResult.put("lee", "꽝");
        mockResult.put("jung", "3500");

        //when
        GameResult gameResult = new GameResult(mockResult);

        // then
        assertThatExceptionOfType(IsNotInUserNamesException.class)
                .isThrownBy(() -> gameResult.getMatchedItem("park"));
    }

    @Test
    public void 해당_사용자_있으면_아이템_출력() throws IsNotInUserNamesException {
        // given
        Map<String, String> mockResult = new HashMap<>();
        mockResult.put("kim", "꽝");
        mockResult.put("lee", "꽝");
        mockResult.put("jung", "3500");

        //when
        GameResult gameResult = new GameResult(mockResult);
        String item = gameResult.getMatchedItem("jung");

        // then
        assertThat(item).isEqualTo("3500");
    }

    @Test
    public void all_입력_시_빈문자열_반환() throws IsNotInUserNamesException {
        // given
        Map<String, String> mockResult = new HashMap<>();
        mockResult.put("kim", "꽝");
        mockResult.put("lee", "꽝");
        mockResult.put("jung", "3500");

        //when
        GameResult gameResult = new GameResult(mockResult);
        String item = gameResult.getMatchedItem("all");

        // then
        assertThat(item).isEqualTo(EMPTY_STRING_FOR_INDICATE_ALL_RESULT);
    }
}