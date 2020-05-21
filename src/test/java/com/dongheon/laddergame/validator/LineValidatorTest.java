package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.ContinuedTrueException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineValidatorTest {

    @Test
    public void 연속된_다리_생성_시_예외_발생() {
        // given
        List<Boolean> hasContinuedTrue = Arrays.asList(true, true, false, true);

        // then
        assertThatExceptionOfType(ContinuedTrueException.class)
                .isThrownBy(() -> LineValidator.validate(hasContinuedTrue));
    }

    @Test
    public void 연속된_다리_생성_안하면_예외_발생_안함() throws Exception {
        // given
        List<Boolean> hasContinuedTrue = Arrays.asList(true, false, true, false);

        // then
        LineValidator.validate(hasContinuedTrue);
    }
}