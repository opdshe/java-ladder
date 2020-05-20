package com.dongheon.laddergame.utils;

import java.util.List;
import java.util.function.Predicate;
public class ExceptionDetector {

    public static <T> void detectException(Exception exception, List<T> list, Predicate<T> p) throws Exception {
        for (T t : list) {
            throwException(exception, t, p);
        }
    }

    public static <T> void throwException (Exception exception, T t, Predicate<T> p) throws Exception {
        if (p.test(t)) {
            throw exception;
        }
    }
}