package com.dongheon.laddergame.validator;


import com.dongheon.laddergame.domain.User;
import com.dongheon.laddergame.exceptions.EmptyInputException;
import com.dongheon.laddergame.exceptions.ExceptionDetector;
import com.dongheon.laddergame.exceptions.IllegalNameLengthException;
import com.dongheon.laddergame.utils.Converter;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

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
        String incorrectNameInput = "strongMinsu, macbook";
        List<String> converted = Converter.stringToList(incorrectNameInput);
        Predicate<String> isCorrectLength = (String name) -> name.length() >= User.MIN_USER_NAME && name.length() <= User.MAX_NAME_LENGTH;

        // then
        assertThatExceptionOfType(IllegalNameLengthException.class)
                .isThrownBy(() -> ExceptionDetector.detectException(new IllegalNameLengthException(), converted, isCorrectLength));
    }

}