package com.example.ticTacToe;

import java.util.Queue;
import java.util.Scanner;

public class GameBoard {

    private char [][]board;
    private int boardSize;
    private Queue<Player> nextTurn;
    private Scanner input;
    private static GameBoard gameBoard;

    private GameBoard(int boardSize,Queue<Player> nextTurn,Scanner input){
        this.boardSize=boardSize;
        this.nextTurn=nextTurn;
        this.input=input;
        this.board = new char[boardSize][boardSize];
    }

    public static GameBoard getInstance(int boardSize,Queue<Player> nextTurn,Scanner input){
        if (gameBoard==null){
            gameBoard = new GameBoard(boardSize,nextTurn,input);
        }
        return gameBoard;
    }

    public void startGame(){
        while(nextTurn.size()>1) {
            Player player = nextTurn.remove();
            System.out.println("Player " + player.getPlayerName());
            int x = input.nextInt(), y = input.nextInt();
            board[x][y]=player.getPlayerSymbol();
            displayBoard();
            boolean hasWon = checkWin(board[x][y]);
            if(hasWon){
                System.out.println(player.getPlayerName()+" won");
            }else{
                nextTurn.add(player);
            }
        }
    }

    private void displayBoard() {
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private boolean checkWin(char ch){
        boolean rowCheck = checkRow(ch);
        boolean colCheck = checkCol(ch);
        boolean diagCheck = checkDiag(ch);
        boolean antiDiagCheck = checkAntiDiag(ch);

        return rowCheck || colCheck || diagCheck || antiDiagCheck;
    }

    private boolean checkDiag(char ch) {
        int i=0,j=0;
        boolean flag=true;
        while(i<boardSize && j<boardSize){
            if(board[i][j]!=ch) {
                flag = false;
                break;
            }
            i++;
            j++;
        }
        return flag;
    }

    private boolean checkAntiDiag(char ch) {
        int i=boardSize-1,j=0;
        boolean flag=true;
        while(i>=0 && j<boardSize){
            if(board[i][j]!=ch) {
                flag = false;
                break;
            }
            i--;
            j++;
        }
        return flag;
    }

    private boolean checkRow(char ch){
        for(int i=0;i<boardSize;i++){
            boolean flag=true;
            for(int j=0;j<boardSize;j++){
                if(board[i][j]!=ch){
                    flag=false;
                    break;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }

    private boolean checkCol(char ch){
        for(int i=0;i<boardSize;i++){
            boolean flag=true;
            for(int j=0;j<boardSize;j++){
                if(board[j][i]!=ch){
                    flag=false;
                    break;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }
}
