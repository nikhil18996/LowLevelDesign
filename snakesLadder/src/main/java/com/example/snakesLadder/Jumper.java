package com.example.snakesLadder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Jumper {
    private int startPoint;
    private int endPoint;
}
