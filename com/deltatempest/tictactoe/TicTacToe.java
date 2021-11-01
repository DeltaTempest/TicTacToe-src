package com.deltatempest.tictactoe;

import java.util.*;

public class TicTacToe {

    static List<Integer> playerPosition = new ArrayList<>();
    static List<Integer> cpuPosition = new ArrayList<>();

    public static void main(String[] args) {
        String winnertxt = "";
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

        printBoard(theBoard);
        boolean gameFinish = false;
        while (gameFinish == false) {
            System.out.print("Please Insert 1 - 9: ");
            playerPos = userInput.nextInt();
            while (playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)) {
                System.out.print("Position taken please choose another number");
                playerPos = userInput.nextInt();
            }
            xOrO(theBoard, playerPos, "Player");
            winnertxt = checkWinner();
            System.out.println(winnertxt);
            if (winnertxt.length() > 0) {
                break;
            }
            cpuPos = rand.nextInt(9) + 1;
            while (cpuPosition.contains(cpuPos) || playerPosition.contains(cpuPos)) {
                System.out.println("CPU choosing a number...");
                cpuPos = rand.nextInt(9) + 1;
            }
            System.out.println("CPU choose: " + cpuPos);
            xOrO(theBoard, cpuPos, "cpu");
            printBoard(theBoard);
            winnertxt = checkWinner();
            System.out.println(winnertxt);
            if (winnertxt.length() > 0) {
                break;
            }

        }

        printBoard(theBoard);
    }

    static String checkWinner() {

        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> bottomRow = Arrays.asList(7,8,9);
        List<Integer> leftCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> rightCol = Arrays.asList(3,6,9);
        List<Integer> cross1 = Arrays.asList(1,5,9);
        List<Integer> cross2 = Arrays.asList(3,5,7);

        List<List> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);

        for (List list : winningConditions)
        if (playerPosition.containsAll(list)) {
            return "Congrast! you won the game!";
        }
        else if (cpuPosition.containsAll(list)) {
            return "CPU Wins better luck next time!";
        } else if (playerPosition.size() + cpuPosition.size() == 9) {
            return "Game tied!";
        }

        return "";
    }

    static void xOrO(char theBoard[][], int pos, String user) {
        char ch = ' ';
        if (user.equalsIgnoreCase("player")) {
            ch = 'X';
            playerPosition.add(pos);
        } else if (user.equalsIgnoreCase("cpu")) {
            ch = 'O';
            cpuPosition.add(pos);
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
