package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.exceptions.IllegalNameLengthException;
import com.dongheon.laddergame.utils.Converter;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserNameValidatorTest {
    @Test
    public void 빈문자열_입력시_예외_발생한다() throws Exception {
        // given
        String emptyString = "\n";
        List<String> converted = Converter.stringToList(emptyString);

        // then
        assertThatExceptionOfType(EmptyInputException.class)
                .isThrownBy(() -> UserNameValidator.test(converted));
    }

    @Test
    public void 올바르지_않은_길이의_이름_입력시_예외_발생한다() throws Exception {
        // given
        String incorrectNameInput = "strongdongheon, papajohns";
        List<String> convertedName = Converter.stringToList(incorrectNameInput);

        // then
        assertThatExceptionOfType(IllegalNameLengthException.class)
                .isThrownBy(() -> UserNameValidator.test(convertedName));
    }

    @Test
    public void 올바른_길이의_이름_입력시_예외_발생_안함() throws Exception {
        // given
        String correctNameInput = "lee, kim";
        List<String> convertedName = Converter.stringToList(correctNameInput);

        // then
        UserNameValidator.test(convertedName);
    }

}