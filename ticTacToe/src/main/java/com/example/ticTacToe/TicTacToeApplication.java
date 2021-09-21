package com.example.ticTacToe;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {

		Player player1 = Player.builder().playerName("player1").playerSymbol('x').build();
		Player player2 = Player.builder().playerName("player2").playerSymbol('o').build();
		Queue<Player> nextTurn = new LinkedList<>();
		nextTurn.add(player1);
		nextTurn.add(player2);
		GameBoard board = GameBoard.getInstance(3,nextTurn,new Scanner(System.in));
		board.startGame();
	}

}
