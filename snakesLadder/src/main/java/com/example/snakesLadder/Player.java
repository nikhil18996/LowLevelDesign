package com.example.snakesLadder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private String playerName;
    private String id;
    private int position;
}
