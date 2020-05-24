package com.dongheon.laddergame.exceptions;

import java.util.function.Predicate;
public class ExceptionDetector {

    public static <T> void throwException (Exception exception, T t, Predicate<T> p) throws Exception {
        if (p.test(t)) {
            throw exception;
        }
    }
}
