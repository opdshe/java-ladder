package com.dongheon.laddergame.utils;


import com.dongheon.laddergame.exceptions.ExceptionDetector;
import org.junit.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ExceptionDetectorTest {

    @Test
    public void Predicate_참이면_예외_발생_한다() {
        // given
        Predicate<String> alwaysTruePredicate = (String anything) -> true;
        String target = "무조건 예외 발생";

        // then
        assertThatExceptionOfType(TestException.class)
                .isThrownBy(() -> ExceptionDetector.throwException(new TestException(), target, alwaysTruePredicate));
    }

    private class TestException extends Exception {
        public TestException() {
            super("테스트 예외입니다.");
        }
    }

}