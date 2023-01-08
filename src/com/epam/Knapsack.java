package com.epam;

public class Knapsack {
    private int capacity;
    private int size;
    private int[] values;
    private int[] weights;
    private int[][] dp;


    public Knapsack(int capacity,int size,int[] values,int[] weights) {
        this.capacity = capacity;
        this.size = size;
        this.values = values;
        this.weights = weights;
        this.dp = new int[size+1][capacity+1];
    }
    public Knapsack(int capacity,int[] prices) {
        this.capacity = capacity;
        this.values = prices;
        this.dp = new int[prices.length+1][capacity+1];
    }

    public int solveRod() {
        for (int i = 1; i <= values.length ; i++) {
            for (int j = 1 ; j <= capacity ; j++) {
                int notTaken = dp[i-1][j];
                int taken = 0;
                if(i<=j){
                    taken = values[i]+dp[i-1][j-i];
                }
                dp[i][j]= Math.max(notTaken,taken);
            }
        }return dp[values.length][capacity];
    }

    public int solve() {
        for (int i = 1; i <= size ; i++) {
            for (int j = 1 ; j <= capacity ; j++) {
                int notTaken = dp[i-1][j];
                int taken = 0;
                int currentWeight = weights[i];
                if(currentWeight<=j){
                    taken = values[i]+dp[i-1][j-currentWeight];
                }
                dp[i][j]= Math.max(notTaken,taken);
            }
        }return dp[size][capacity];
    }
    public static void main(String[] args) {
        int size = 4;
        int capacity = 7;
        int[] values = {0,1,2,13,14};
        int[] weights = {0,1,2,3,4};
        Knapsack knapsack = new Knapsack(capacity,size,values,weights);
        int solve = knapsack.solve();

        Knapsack knapsack1 = new Knapsack(5,new int[]{0,2,5,7,3,9});
        int solve1 = knapsack1.solveRod();
        System.out.println(solve1);
    }
}
