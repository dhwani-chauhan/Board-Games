package com.BoardGames.BoardGamesSystem.TicTacToe;

import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        int x=0,y=0;
        do{
            System.out.println(t.player == t.X ? "Player X" : "Player O");
            System.out.println("Enter x and y axis");
            x = sc.nextInt();
            y = sc.nextInt();
            t.putSign(x,y);
            System.out.println(t.toString());
            System.out.println("__________________________");
            t.displayWinner();
        }while(t.isEmpty);
    }
}
