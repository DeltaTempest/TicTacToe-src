package com.deltatempest.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();
        int playerPos = 0, cpuPos;

        char theBoard[][] = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        System.out.println("Welcome to TicTacToe Games!");
        System.out.println("test ini git hub");

        boolean gameFinish = false;
        while (gameFinish == false) {

            printBoard(theBoard);
            System.out.print("Please Insert 1 - 9: ");

            playerPos = userInput.nextInt();
            xOrO(theBoard, playerPos, "Player");

            cpuPos = rand.nextInt(9) + 1;
            System.out.println("CPU choose: " + cpuPos);
            xOrO(theBoard, cpuPos, "cpu");

        }












    }

    static void xOrO(char theBoard[][], int pos, String user) {
        char ch = ' ';
        if (user.equalsIgnoreCase("player")) {
            ch = 'X';
        } else if (user.equalsIgnoreCase("cpu")) {
            ch = 'O';
        }

        if (pos == 1) {
            theBoard[0][0] = ch;
        } else if (pos == 2) {
            theBoard[0][2] = ch;
        } else if (pos == 3) {
            theBoard[0][4] = ch;
        }else if (pos == 4) {
            theBoard[2][0] = ch;
        }else if (pos == 5) {
            theBoard[2][2] = ch;
        }else if (pos == 6) {
            theBoard[2][4] = ch;
        }else if (pos == 7) {
            theBoard[4][0] = ch;
        }else if (pos == 8) {
            theBoard[4][2] = ch;
        }else if (pos == 9) {
            theBoard[4][4] = ch;
        }


    }


    static void printBoard (char[][] ch) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                System.out.print(ch[i][j]);
            }
            System.out.println();
        }
    }
}
