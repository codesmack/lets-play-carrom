package com.sahaj.games.carrom.cleanstrike.entity;

import com.sahaj.games.carrom.cleanstrike.Subscriber;
import com.sahaj.games.carrom.cleanstrike.striketypes.Strike;

import java.util.Map;

/**
 * Created by Aniruddha on 16-11-2018.
 */
public class Player implements Subscriber {

    private final Striker striker;
    private int currentScore;
    private int NA = 0;
    private int consecutiveUnsuccessfulAttempts;

    public Player(Striker striker) {
        this.striker = striker;
    }

    public void playStroke() {
        striker.hitCoin();
    }

    public int currentScore() {
        return this.currentScore;
    }

    @Override
    public void update(Strike strike) {
        final Map<String, Integer> currentStats = strike.updateStatsPerStrike(NA, NA, currentScore);
        this.currentScore = currentStats.get("currentScore");
        deductScoreIfConsecutiveUnsuccessfulAttempts(currentStats);
    }

    private void deductScoreIfConsecutiveUnsuccessfulAttempts(Map<String, Integer> currentStats) {
        int currUnsuccessfulAttempt = currentStats.get("isAttemptUnsuccessful");
        if (currUnsuccessfulAttempt == 0) {
            consecutiveUnsuccessfulAttempts = 0;
        }
        consecutiveUnsuccessfulAttempts = consecutiveUnsuccessfulAttempts + currUnsuccessfulAttempt;
        if (consecutiveUnsuccessfulAttempts == 3) {
            consecutiveUnsuccessfulAttempts = 0;
            this.currentScore = this.currentScore - 1;
        }
    }
}
