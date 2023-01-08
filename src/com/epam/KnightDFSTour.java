package com.epam;

public class KnightDFSTour {

    private int boardSize;
    private int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};
    private int[][] chessBoard;

    public KnightDFSTour(int noOfRecords) {
        this.boardSize = noOfRecords;
        this.chessBoard = new int[noOfRecords][noOfRecords];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                this.chessBoard[i][j] = Integer.MIN_VALUE;
    }


    public void solve() {
        if (dfs(1, 0, 0)) print();
        else System.out.println("No solution");
    }

    private boolean dfs(int stepCounter, int x, int y) {
        //base condition
        if (stepCounter == boardSize * boardSize)
            return true;
        for (int i = 0; i < xMoves.length; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];
            if (isValid(nextX, nextY)) {
                this.chessBoard[nextX][nextY] = stepCounter;
                if (dfs(stepCounter + 1, nextX, nextY)) return true;
                this.chessBoard[nextX][nextY] = Integer.MIN_VALUE;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        return !(x < 0 || x >= boardSize || y < 0 || y >= boardSize || this.chessBoard[x][y] != Integer.MIN_VALUE);
    }

    private void print() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++)
                System.out.print(chessBoard[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        KnightDFSTour dfsBackTracking = new KnightDFSTour(5);
        dfsBackTracking.solve();
    }
}
