package com.dongheon.laddergame.domain;

import com.dongheon.laddergame.exceptions.IsNotInUserNamesException;

import java.util.Collections;
import java.util.Map;

import static com.dongheon.laddergame.controller.LadderGame.SHOW_EVERYONE;

public class GameResult {
    public static final String EMPTY_STRING_FOR_INDICATE_ALL_RESULT = "";

    private Map<String, String> result;

    public GameResult(Map<String, String> result) {
        this.result = result;
    }

    public String getMatchedItem(String userName) throws IsNotInUserNamesException {
        if (userName.equals(SHOW_EVERYONE)) {
            return EMPTY_STRING_FOR_INDICATE_ALL_RESULT;
        }
        if (!result.containsKey(userName)) {
            throw new IsNotInUserNamesException();
        }
        return result.get(userName);
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
