package com.BoardGames.BoardGamesSystem.SnakeNLadder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeNLadder {
    final static int WINPOINT = 100;

    static Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
    static Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
    {
        snake.put(99,54);
        snake.put(70,55);
        snake.put(52,42);
        snake.put(25,2);
        snake.put(95,72);

        ladder.put(6,25);
        ladder.put(11,40);
        ladder.put(60,85);
        ladder.put(46,90);
        ladder.put(17,69);
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        int player1 = 0, player2 = 0;
        int currentPlayer = -1;
        String str;
        int dice = 0;
        do{
            System.out.println(currentPlayer == -1 ? "\nFirst Player":"\n Second Player");
            System.out.println("Press r to roll dice");
            str = sc.next();
            dice = rollDice();

            if(currentPlayer == -1){
                player1 = calculatePlayerValue(player1,dice);
                System.out.println("First Player : " + player1);
                System.out.println("Second Player : " + player2);

                if(isWin(player1)){
                    System.out.println("First Player Wins");
                    return;
                }
            }
            else{
                player2 = calculatePlayerValue(player2,dice);
                System.out.println("First Player : " + player1);
                System.out.println("Second Player : " + player2);

                if(isWin(player2)){
                    System.out.println("Second Player Wins");
                    return;
                }
            }
            currentPlayer = -currentPlayer;
        }while("r".equals(str));
    }

    public int rollDice(){
        int n=0;
        Random r = new Random();
        n=r.nextInt(7);
        return (n==0?1:n);
    }

    public boolean isWin(int player){
        return WINPOINT == player;
    }

    public int calculatePlayerValue(int player,int dice){
        player += dice;

        if(player > WINPOINT){
            player -= dice;
            return player;
        }

        if(null != snake.get(player)){
            System.out.println("Swallowed by Snake");
            player = snake.get(player);
        }

        if(null != ladder.get(player)){
            System.out.println("Climb up Ladder");
            player = ladder.get(player);
        }
        return player;
    }

}
