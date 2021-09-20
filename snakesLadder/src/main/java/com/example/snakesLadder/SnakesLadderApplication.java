package com.example.snakesLadder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

@SpringBootApplication
public class SnakesLadderApplication {

	public static void main(String[] args) {

		Player player1 =  Player.builder()
				.playerName("Player1")
				.id("123")
				.position(0)
				.build();

		Player player2 =  Player.builder()
				.playerName("Player2")
				.id("456")
				.position(0)
				.build();

		Dice dice =  Dice.builder()
				.numberOfDice(1).build();

		Queue< Player> nextTurn = new LinkedList<>();
		nextTurn.add(player1);
		nextTurn.add(player2);
		Jumper ladder =  Jumper.builder().startPoint(3).endPoint(99).build();
		Jumper snake =  Jumper.builder().startPoint(98).endPoint(4).build();

		LadderBoard board = LadderBoard.getLadderBoardInstance(dice,nextTurn, Collections.singletonList(snake),Collections.singletonList(ladder),100);
		board.startGame();
	}

}
