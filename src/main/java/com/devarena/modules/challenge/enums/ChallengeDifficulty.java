package com.devarena.modules.challenge.enums;

public enum ChallengeDifficulty {
    EASY, MEDIUM, HARD;

    public int getXpReward() {
        return switch (this) {
            case EASY -> 10;
            case MEDIUM -> 30;
            case HARD -> 100;
        };
    }
}
