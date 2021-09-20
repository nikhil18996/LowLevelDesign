package com.example.snakesLadder;

import java.util.List;
import java.util.Queue;

public class LadderBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private int boardSize;
    private static LadderBoard ladderBoard;

    private LadderBoard( Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.boardSize = boardSize;
    }

    public static LadderBoard getLadderBoardInstance( Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders, int boardSize){
        if(ladderBoard==null){
            ladderBoard=new LadderBoard(dice,nextTurn,snakes,ladders,boardSize);
        }
        return ladderBoard;
    }

    public void startGame(){
        while(nextTurn.size()>1){
             Player player = nextTurn.remove();
            int step = dice.rollDice();
            System.out.println("Player "+player.getPlayerName()+" got "+step);
            int newPosition = step+player.getPosition();
            if(newPosition > boardSize){
                nextTurn.add(player);
            }else{
                boolean isSnake = false,isLadder=false;
                for( Jumper snake:snakes){
                    if(snake.getStartPoint()==newPosition){
                        newPosition= snake.getEndPoint();
                        isSnake=true;
                        System.out.println("Player "+player.getPlayerName()+" got hit by snake");
                        break;
                    }
                }
                for ( Jumper ladder:ladders){
                    if(ladder.getStartPoint()==newPosition){
                        newPosition= ladder.getEndPoint();
                        System.out.println("Player "+player.getPlayerName()+" got hit by ladder");
                        isLadder=true;
                        break;
                    }
                }
                player.setPosition(newPosition);
                System.out.println("new position "+player.getPosition());
                if(checkWinner(player.getPosition())){
                    System.out.println("Player "+player.getPlayerName()+" won");
                }else{
                    nextTurn.add(player);
                }
            }
        }
    }

    private boolean checkWinner(int position){
        return position==boardSize;
    }

}
