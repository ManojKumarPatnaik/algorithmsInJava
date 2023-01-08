package com.epam;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimsLazyAlgo {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;
    private PriorityQueue<Edge> edgePriorityQueue;
    private Set<Vertex> unvistedEdges;
    private double fullWeight;


    public PrimsLazyAlgo(List<Edge> edgeList, List<Vertex> vertex) {
        this.edgeList = edgeList;
        this.vertexList = vertex;
        this.edgePriorityQueue = new PriorityQueue<>();
        this.unvistedEdges = new HashSet<>(vertexList);
    }

    public void solve(Vertex vertex) {
        unvistedEdges.remove(vertex);
        while (!unvistedEdges.isEmpty()){

            for (Edge edge : vertex.getAdjacentEdges()) {
                if (unvistedEdges.contains(edge.getTargetVertex())) {
                    edgePriorityQueue.add(edge);
                }
            }
            Edge minEdge = edgePriorityQueue.remove();

            if (!unvistedEdges.contains(minEdge.getTargetVertex())) continue;
            edgeList.add(minEdge);
            fullWeight += minEdge.getWeight();
            vertex = minEdge.getTargetVertex();
            unvistedEdges.remove(vertex);
        }
    }

    public void show() {
        System.out.println(fullWeight);
        for (Edge edge : edgeList) {
            System.out.println(edge.getSourceVertex() + " " + edge.getTargetVertex());
        }
    }
}
