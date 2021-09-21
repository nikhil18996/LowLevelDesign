package com.example.ticTacToe;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private String playerName;
    private String id;
    private char playerSymbol;
}
