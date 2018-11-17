package com.sahaj.games.carrom.cleanstrike;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class DefunctStrike extends Strike {

    @Override
    protected void deductCoinForTheStrikePlayed() {
        this.numberOfCoinsToDeduct = 1;
    }

    @Override
    protected void addOrDeductPointsFromPlayer() {
        this.pointsForPlayer = -2;
    }

    @Override
    protected int isAttemptUnsuccessful() {
        return 1;
    }

    /*final List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }

    @Override
    public void execute() {

    }

    @Override
    public Map<String, Integer> updateCurrentStats(int blackCoins, int redCoins, int currentScore) {
        return null;
    }*/
}