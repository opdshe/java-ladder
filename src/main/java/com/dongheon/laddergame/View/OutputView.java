package com.dongheon.laddergame.View;

import com.dongheon.laddergame.domain.ladder.Ladder;
import com.dongheon.laddergame.domain.ladder.Line;

import java.util.List;

public class OutputView {
    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";
    private static final String BOUNDARY = "|";
    private static final String RESULT_OF_LADDER_GAME = "사다리 결과";

    public static void printMessage(String s) {
        System.out.println(s);
    }

    public static void printResult(Ladder ladder, List<String> userNames, List<String> options) {
        printMessage(RESULT_OF_LADDER_GAME);
        printInOneLine(userNames);
        printLadder(ladder);
        printInOneLine(options);
    }

    private static void printLadder(Ladder ladder) {
        int maxHeight = ladder.getMaxHeight();
        for (int i = 0; i < maxHeight; i++) {
            printLadderOneLine(ladder.getLine(i));
        }
    }

    private static void printLadderOneLine(Line line) {
        int countOfColumn = line.getSize();
        StringBuilder ladderOneLine = new StringBuilder();
        ladderOneLine.append(EMPTY);

        for (int column = 0; column < countOfColumn - 1; column++) {
            ladderOneLine.append(BOUNDARY);
            ladderOneLine.append(getOnePoint(line, column));
        }
        ladderOneLine.append(BOUNDARY);
        printMessage(ladderOneLine.toString());
    }

    private static String getOnePoint(Line line, int column) {
        return line.hasLine(column) ? BRIDGE : EMPTY;
    }

    private static void printInOneLine(List<String> target) {
        String oneLineUserName = target.stream()
                .map(name -> String.format("%6s", name))
                .reduce("", (a, b) -> a + b);
        printMessage(oneLineUserName);
    }
}
