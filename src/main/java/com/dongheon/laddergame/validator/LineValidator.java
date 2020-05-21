package com.dongheon.laddergame.validator;

import com.dongheon.laddergame.exceptions.ContinuedTrueException;
import com.dongheon.laddergame.utils.ExceptionDetector;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LineValidator {

    public static void validate(List<Boolean> line) throws Exception {
        ExceptionDetector.throwException(new ContinuedTrueException(), line, continuedTruePredicate);
    }

    private static Predicate<List<Boolean>> continuedTruePredicate = (line) ->
            IntStream.range(0, line.size() - 1)
                    .boxed()
                    .anyMatch(i -> isContinuedTrue(line, i, i + 1));

    private static boolean isContinuedTrue(List<Boolean> line, int currentIdx, int nextIdx) {
        return line.get(currentIdx) & line.get(nextIdx);
    }
}
