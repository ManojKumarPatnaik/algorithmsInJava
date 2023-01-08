package com.epam;

public class SubsetSum {
    private int capacity;
    private int[] values;
    private boolean[][] dp;


    public SubsetSum(int capacity, int[] values) {
        this.capacity = capacity;
        this.values = values;
        this.dp = new boolean[values.length + 1][capacity + 1];
    }

    public void solve() {

        for (int i = 0; i <= values.length; i++) dp[i][0] = true;
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < values[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (dp[i][j]) {
                        dp[i][j] = dp[i - 1][j];
                    } else
                        dp[i][j] = dp[i - 1][j - values[i - 1]];
                }
            }
        }
    }

    public static void main(String[] args) {
        int capacity = 8;
        int[] values = {3,4,5};

        SubsetSum knapsack1 = new SubsetSum(capacity, values);
        knapsack1.solve();
        knapsack1.show();
    }

    private void show() {
        System.out.println("Is there a solution " + dp[values.length][capacity]);
        if (dp[values.length][capacity]) {
            int rI = values.length, cI = capacity;
            while (rI > 0 || cI > 0) {
                if (dp[rI][cI] == dp[rI - 1][cI]) {
                    rI--;
                } else {
                    System.out.println(values[rI - 1]);
                    cI -= values[rI - 1];
                    rI--;
                }
            }
        }
    }
}
