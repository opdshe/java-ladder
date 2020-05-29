package com.dongheon.laddergame.domain;

import com.dongheon.laddergame.domain.ladder.Ladder;
import com.dongheon.laddergame.domain.ladder.Line;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 결과_도출_확인() {
        // given
        List<Line> specifiedLines = Arrays.asList(
                new Line(Arrays.asList(true, false, true, false))
        );
        Ladder specifiedLadder = new Ladder(specifiedLines);
        List<String> userNames = Arrays.asList("kim", "lee", "hwang", "jung");
        List<String> items = Arrays.asList("꽝", "꽝", "3500", "5000");

        // when
        Map<String, String> result = Calculator.calculate(specifiedLadder, userNames, items);

        // then
        assertThat(userNames.stream()
                .map(result::get)
                .collect(Collectors.toList()))
                .isEqualTo(Arrays.asList("꽝", "꽝", "5000", "3500"));
    }

}