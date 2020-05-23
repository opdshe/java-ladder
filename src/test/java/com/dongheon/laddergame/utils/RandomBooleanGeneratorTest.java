package com.dongheon.laddergame.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBooleanGeneratorTest {
    @Test
    public void boolean_생성_확인() {
        assertThat(RandomBooleanGenerator.generate()).isInstanceOf(Boolean.class);
    }
}