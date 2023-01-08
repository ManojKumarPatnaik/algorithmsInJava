package com.epam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijstraAlgo {

    public void solve(Vertex source) {
        source.setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            Vertex actualVertex = queue.poll();
            for (Edge edge : actualVertex.getAdjacentEdges()) {
                Vertex targetVertex = edge.getTargetVertex();
                Vertex sourceVertex = edge.getSourceVertex();
                double distance = actualVertex.getDistance() + edge.getWeight();
                if (distance < targetVertex.getDistance()) {
                    queue.remove(targetVertex);
                    targetVertex.setDistance(distance);
                    targetVertex.setPredecessor(actualVertex);
                    queue.add(targetVertex);
                }
            }

        }
    }

    public int getMaximumGold(int[][] G) {
        int max = 0, m = G.length, n = G[0].length;
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (G[r][c] != 0)
                    max = Math.max(max, dfs(G, m, n, r, c, 0));
        return max;
    }
    int moves[] = {0, 1, 0, -1, 0};
    boolean flag = false;
    public int dfs(int[][] G, int m, int n, int r, int c, int used) {
        if (used == 25) flag = true; //max possibility
        if (r < 0 || r == m || c < 0 || c == n || G[r][c] == 0) return 0;
        int orignal = G[r][c], max = 0;
        G[r][c] = 0;//mark as visted
        for (int i = 0; i < 4; i++)
            if (!flag)
                max = Math.max(max, dfs(G, m, n, r + moves[i], c + moves[i + 1], used + 1));
        G[r][c] = orignal;//backtrack
        return max + orignal;
    }



    public List<Vertex> getShortestPath(Vertex targetVertex) {
        List<Vertex> shortestPath = new ArrayList<>();
        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
            shortestPath.add(vertex);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    public static void main(String[] args) {
        Vertex vertex0 = new Vertex("A");
        Vertex vertex1 = new Vertex("B");
        Vertex vertex2 = new Vertex("C");
        Vertex vertex3 = new Vertex("D");
        Vertex vertex4 = new Vertex("E");
        Vertex vertex5 = new Vertex("F");
        Vertex vertex6 = new Vertex("G");
        Vertex vertex7 = new Vertex("H");

        vertex0.addNeighbor(new Edge(5, vertex0, vertex1));
        vertex0.addNeighbor(new Edge(9, vertex0, vertex4));
        vertex0.addNeighbor(new Edge(8, vertex0, vertex7));

        vertex1.addNeighbor(new Edge(12, vertex1, vertex2));
        vertex1.addNeighbor(new Edge(15, vertex1, vertex3));
        vertex1.addNeighbor(new Edge(4, vertex1, vertex7));

        vertex2.addNeighbor(new Edge(3, vertex2, vertex3));
        vertex2.addNeighbor(new Edge(11, vertex2, vertex6));

        vertex3.addNeighbor(new Edge(9, vertex3, vertex6));

        vertex4.addNeighbor(new Edge(4, vertex4, vertex5));
        vertex4.addNeighbor(new Edge(20, vertex4, vertex6));
        vertex4.addNeighbor(new Edge(5, vertex4, vertex7));

        vertex5.addNeighbor(new Edge(1, vertex5, vertex2));
        vertex5.addNeighbor(new Edge(13, vertex5, vertex7));

        vertex7.addNeighbor(new Edge(7, vertex7, vertex2));
        vertex7.addNeighbor(new Edge(6, vertex7, vertex5));
        DijstraAlgo dijstraAlgo = new DijstraAlgo();
        dijstraAlgo.solve(vertex0);
        List<Vertex> shortestPath = dijstraAlgo.getShortestPath(vertex6);
        System.out.println(shortestPath);
    }

}

