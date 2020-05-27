package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.exceptions.IsNotOverZeroException;
import com.dongheon.laddergame.exceptions.IsNotSameWithCountOfUserException;
import com.dongheon.laddergame.utils.Converter;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OptionValidatorTest {

    @Test
    public void 빈문자열_입력시_예외_발생한다() {
        // given
        String emptyString = "\n";
        int countOfUser = 4;
        List<String> converted = Converter.stringToList(emptyString);

        // then
        assertThatExceptionOfType(EmptyInputException.class)
                .isThrownBy(() -> OptionValidator.validate(converted, countOfUser));
    }

    @Test
    public void 상금이_없으면_예외_발생한다() {
        // given
        String incorrectOptions = "꽝, 꽝, 꽝, 꽝";
        int countOfUser = 4;
        List<String> converted = Converter.stringToList(incorrectOptions);

        // then
        assertThatExceptionOfType(IsNotOverZeroException.class)
                .isThrownBy(() -> OptionValidator.validate(converted, countOfUser));
    }

    @Test
    public void 상금이_있으면_예외_발생_안함() throws Exception {
        // given
        String correctOptions = "꽝, 꽝, 꽝, 3500";
        int countOfUser = 4;
        List<String> convertedOptions = Converter.stringToList(correctOptions);

        // then
        OptionValidator.validate(convertedOptions, countOfUser);
    }

    @Test
    public void 옵션_개수가_사용자_수와_일치안하면_예외_발생한다() {
        // given
        String incorrectOptions = "꽝, 꽝, 꽝, 3500";
        int countOfUser = 3;
        List<String> converted = Converter.stringToList(incorrectOptions);

        // then
        assertThatExceptionOfType(IsNotSameWithCountOfUserException.class)
                .isThrownBy(() -> OptionValidator.validate(converted, countOfUser));
    }

    @Test
    public void 옵션_개수가_사용자_수와_일치하면_예외_발생_안_한다() throws Exception {
        // given
        String incorrectOptions = "꽝, 꽝, 꽝, 3500";
        int countOfUser = 4;
        List<String> converted = Converter.stringToList(incorrectOptions);

        // then
        OptionValidator.validate(converted, countOfUser);
    }
}