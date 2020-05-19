package com.dongheon.laddergame.validator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class ValidatorTest {

    @Test
    public void 당첨옵션이_1개_미만이면_예외_발생한다() {
        //given
        List<String> options = Arrays.asList("꽝", "꽝", "꽝", "꽝");

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()-> Validator.validateOptions(options))
                .withMessage("당첨 옵션은 최소 하나 이상으로 설정해주세요. ");
    }

    @Test
    public void 당첨옵션이_1개_이상이면_예외_발생_안_한다() {
        //given
        List<String> options = Arrays.asList("3500", "꽝", "꽝", "꽝");

        //then
        Validator.validateOptions(options);
    }

    @Test
    public void 최대높이_1미만이면_예외_발생한다() {
        // given
        String height = "0";
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()-> Validator.validateHeight(height))
                .withMessage("높이는 1이상의 정수로 입력해주세요. ");
    }

    @Test
    public void 최대높이_1이상이면_예외_발생_안_한다() {
        // given
        String height = "1";
        // then
        Validator.validateHeight(height);
    }

}