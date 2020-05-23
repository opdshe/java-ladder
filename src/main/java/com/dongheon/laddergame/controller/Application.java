package com.dongheon.laddergame.controller;

import com.dongheon.laddergame.exceptions.IsNotInUserNamesException;

public class Application {
    public static void main(String[] args) throws IsNotInUserNamesException {
        LadderGame.play();
    }
}
