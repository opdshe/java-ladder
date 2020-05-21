package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.IsNotOverZeroException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MaxHeightValidatorTest {

    @Test
    public void 영_이하의_높이_입력_시_예외_발생() {
        assertThatExceptionOfType(IsNotOverZeroException.class)
                .isThrownBy(() -> MaxHeightValidator.validate(0));
    }

    @Test
    public void 일_이상의_높이_입력_시_예외_발생_안함() throws Exception {
        MaxHeightValidator.validate(1);
    }

}