package com.example.snakesLadder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dice {
    private int numberOfDice;

    public int rollDice(){
        return (int) (Math.random()*(numberOfDice*6-1*numberOfDice)+1);
    }
}
