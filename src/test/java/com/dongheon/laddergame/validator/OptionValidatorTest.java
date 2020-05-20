package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.exceptions.IncorrectCountOfPrizeException;
import com.dongheon.laddergame.utils.Converter;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OptionValidatorTest {
    @Test
    public void 빈문자열_입력시_예외_발생한다() throws Exception {
        // given
        String emptyString = "\n";
        List<String> converted = Converter.stringToList(emptyString);

        // then
        assertThatExceptionOfType(EmptyInputException.class)
                .isThrownBy(() -> OptionValidator.test(converted));
    }

    @Test
    public void 상금이_없으면_예외_발생한다() throws Exception {
        // given
        String incorrectOptions = "꽝, 꽝, 꽝, 꽝";
        List<String> converted = Converter.stringToList(incorrectOptions);

        // then
        assertThatExceptionOfType(IncorrectCountOfPrizeException.class)
                .isThrownBy(() -> OptionValidator.test(converted));
    }

    @Test
    public void 상금이_있으면_예외_발생_안함() throws Exception {
        // given
        String correctOptions = "꽝, 꽝, 꽝, 3500";
        List<String> convertedOptions = Converter.stringToList(correctOptions);

        // then
        OptionValidator.test(convertedOptions);
    }
}