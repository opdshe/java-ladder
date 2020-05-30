package com.dongheon.laddergame.domain.ladder;

import com.dongheon.laddergame.utils.RandomBooleanGenerator;

public class RandomCreateStrategy implements LineCreateStrategy {
    @Override
    public boolean generate() {
        return RandomBooleanGenerator.generate();
    }
}
