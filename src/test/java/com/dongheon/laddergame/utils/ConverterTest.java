package com.dongheon.laddergame.utils;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {
    @Test
    public void stringToList_테스트() {
        // given
        String before = "iwant, mac, book";

        // when
        List<String> after = Converter.stringToList(before);

        // then
        assertThat(after).contains("iwant", "mac", "book");
    }
}