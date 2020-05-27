package com.dongheon.laddergame.domain;

import com.dongheon.laddergame.exceptions.IsNotInUserNamesException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dongheon.laddergame.controller.LadderGame.SHOW_EVERYONE;

public class GameResult {
    private Map<String, String> result;

    public GameResult(List<Integer> ladderResult, List<String> userNames, List<String> options) {
        result = new HashMap<>();
        int countOfUser = userNames.size();
        for (int i = 0; i < countOfUser; i++) {
            result.put(userNames.get(i), options.get(ladderResult.get(i)));
        }
    }

    public String getItem(String userName) throws IsNotInUserNamesException {
        if (userName.equals(SHOW_EVERYONE)) {
            return toString();
        }
        if (!result.containsKey(userName)) {
            throw new IsNotInUserNamesException();
        }
        return result.get(userName);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        result.entrySet()
                .forEach(entry -> stringBuilder.append(entry.getKey())
                        .append(" : ")
                        .append(entry.getValue())
                        .append("\n"));
        return stringBuilder.toString();
    }
}
