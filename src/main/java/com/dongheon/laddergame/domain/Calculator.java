package com.dongheon.laddergame.domain;

import com.dongheon.laddergame.domain.ladder.Ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    public static Map<String, String> calculate(Ladder ladder, List<String> userNames, List<String> items) {
        Map<String, String> result = new HashMap<>();
        List<Integer> itemsIdxes = getItemsIdxes(ladder);
        int countOfUser = userNames.size();
        for (int i = 0; i < countOfUser; i++) {
            result.put(userNames.get(i), items.get(itemsIdxes.get(i)));
        }
        return result;
    }

    private static List<Integer> getItemsIdxes(Ladder ladder) {
        List<Integer> itemsIdxes = new ArrayList<>();
        int countOfUser = ladder.getLine(0).getSize();
        for (int userIdx = 0; userIdx < countOfUser; userIdx++) {
            int optionIdx = getItemIdx(ladder, userIdx);
            itemsIdxes.add(optionIdx);
        }
        return itemsIdxes;
    }

    private static int getItemIdx(Ladder ladder, int column) {
        int currentRow = 0;
        int maxHeight = ladder.getMaxHeight();
        while (currentRow < maxHeight) {
            column = ladder.getLine(currentRow).getPositionAfterMove(column);
            currentRow++;
        }
        return column;
    }
}
