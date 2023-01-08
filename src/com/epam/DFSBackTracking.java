package com.epam;

public class DFSBackTracking {

    private int noOfColors;
    private int noOfVertices;
    private int[] colors;
    private int[][] graph;

    public DFSBackTracking(int[][] graph, int noOfRecords) {
        this.noOfColors = noOfRecords;
        this.noOfVertices = graph[0].length;
        this.graph = graph;
        this.colors = new int[noOfVertices];
    }

    public void solve() {
        if (dfs(0)) print();
        else System.out.println("No solution");
    }

    private boolean dfs(int nodeIndex) {
        if (nodeIndex == noOfVertices) {
            return true;
        }
        for (int i = 1; i <= noOfColors; i++) {
            if (isValid(nodeIndex, i)) {
                colors[nodeIndex] = i;
                if (dfs(nodeIndex + 1)) return true;
            }
        }
        return false;

    }

    private boolean isValid(int index, int colorIndex) {
//        if  adj having same color skip it
        for (int i = 0; i < noOfVertices; i++) {
            if (graph[index][i] == 1 && colors[i] == colorIndex)
                return false;
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < colors.length; i++)
            System.out.println("Node of " + (i + 1) + " has color = " + colors[i]);
    }

    public static void main(String[] args) {
        int G[][] = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0}

        };
        DFSBackTracking dfsBackTracking = new DFSBackTracking(G, 4);
        dfsBackTracking.solve();
    }
}
