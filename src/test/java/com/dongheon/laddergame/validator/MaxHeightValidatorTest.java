package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.IncorrectCountOfHeightException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MaxHeightValidatorTest {
    @Test
    public void 영_이하의_높이_입력_시_예외_발생() {
        // given
        int maxHeight = 0;

        // then
        assertThatExceptionOfType(IncorrectCountOfHeightException.class)
                .isThrownBy(() -> MaxHeightValidator.test(maxHeight));
    }

    @Test
    public void 일_이상의_높이_입력_시_예외_발생_안함() throws Exception {
        // given
        int maxHeight = 1;

        // then
        MaxHeightValidator.test(maxHeight);
    }

}