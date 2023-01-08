package com.epam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SudokoSolver {

    private static final int boardSize =9;
    private static final int minValue =1;
    private static final int maxValue =9;
    private static final int boxSize =3;
    private int[][] graph;

    public SudokoSolver(int[][] graph) {
        this.graph = graph;
    }

    public void solve() {
        if (dfs(0,0)) print();
        else System.out.println("No solution");
    }

    private boolean dfs(int rowInd,int clmInd) {
        //if r=9 check for clm 1 to 9 cells
        if(rowInd==boardSize ){
            clmInd++;
            if(clmInd==boardSize){
                return true;
            }else rowInd=0;
        }

        if(graph[rowInd][clmInd]!=0)return dfs(rowInd+1,clmInd);
        for(int i=minValue;i<=maxValue;i++){
            if(isValid(rowInd,clmInd,i)){
                graph[rowInd][clmInd]=i;
                if(dfs(rowInd+1,clmInd))return true;
                graph[rowInd][clmInd]=0;
            }
        }
        return false;
    }


    private boolean isValid(int rw, int cl,int num) {
//        if  adj having same color skip it
        for (int i = 0; i < boardSize; i++) {
            if(graph[rw][i]==num) return false;
        }
        for (int i = 0; i < boardSize; i++) {
            if(graph[i][cl]==num) return false;
        }
        int rowOffset =(rw/3)*boxSize;
        int clmOffset =(cl/3)*boxSize;
        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if(graph[rowOffset+i][clmOffset+j]==num) return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < boardSize; i++) {
            if(i%3==0) System.out.print(" ");
            for (int j = 0; j < boardSize; j++) {
                if(j%3==0) System.out.print(" ");
                System.out.print( graph[i][j] );
            }
            System.out.println(" ");
        }
    }
    public boolean detectCapitalUse(String w) {
        int l=w.length(),  f=w.charAt(0) ,t=0;
        if(l==1) return true;
        t=w.charAt(1);
        if(f >=65 && f <=90 && t >=65 && t <=90 )
            for(int i=2;i<l;i++){
                t=w.charAt(i);
                if(t>=97 && t<=122) return false;
            }
        else if(f >=65 && f <=90)
            for(int i=1;i<l;i++){
                t=w.charAt(i);
                if(t>=65 && t <=90) return false;
            }else for(int i=0;i<l;i++){
                t=w.charAt(i);
                if(t>=65 && t <=90) return false;
            }
        return true;
    }

    //top down for memo
    private int topDownMemo(int n, Map<Integer,Integer> mp){
        if(!mp.containsKey(n))
            mp.put(n,topDownMemo(n-1,mp)+topDownMemo(n-2,mp));
        return mp.get(n);
    }
    //bottom up for table
    private int bottomUpTable(int n, Map<Integer,Integer> mp){
        for (int i = 2; i <=n ; i++) {
            mp.put(i,mp.get(i-1)+mp.get(i-2));
        }
        return mp.get(n);
    }

    public static void main(String[] args) {
        int G[][] = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        SudokoSolver dfsBackTracking = new SudokoSolver(G);
        System.out.println(dfsBackTracking.detectCapitalUse("FlaG"));
        dfsBackTracking.solve();
        var mp = new HashMap<Integer,Integer>();
        mp.put(0,1);
        mp.put(1,1);
        System.out.println(dfsBackTracking.topDownMemo(8,mp));
        System.out.println(dfsBackTracking.bottomUpTable(8,mp));
        int com = "daf".compareTo("ghi");
        System.out.println(com);
//        System.out.println(Integer.toBinaryString(12));
        
    }
}
