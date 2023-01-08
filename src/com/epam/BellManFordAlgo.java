package com.epam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellManFordAlgo {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;
    private List<Vertex> cycleList;

    public BellManFordAlgo(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
        this.cycleList = new ArrayList<>();
    }

    public void solve(Vertex source) {
        source.setDistance(0);
        for (int i = 0; i < vertexList.size() - 1; i++) {

            for (Edge edge : edgeList) {
                Vertex targetVertex = edge.getTargetVertex();
                Vertex sourceVertex = edge.getSourceVertex();
                double distance = sourceVertex.getDistance() + edge.getWeight();
                if (distance < targetVertex.getDistance()) {
                    targetVertex.setDistance(distance);
                    targetVertex.setPredecessor(sourceVertex);
                }
            }

        }

        for (Edge edge : edgeList) {
            if (edge.getSourceVertex().getDistance() != Double.MAX_VALUE)
                if (hasCycle(edge)) {
                    System.out.println("There is a cycle" + edge);
                    Vertex v = edge.getSourceVertex();
                    while (!v.equals(edge.getTargetVertex())){
                        this.cycleList.add(v);
                        v = v.getPredecessor();
                    }
                    this.cycleList.add(edge.getTargetVertex());
                    return;
                }
        }
    }

    private boolean hasCycle(Edge edge) {
        return edge.getSourceVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
    }


    public void getShortestPath(Vertex targetVertex) {
        if (targetVertex.getDistance() == Double.MAX_VALUE) {
            System.out.println("There is no shortest path");
            return;
        }
        Vertex sourceVertex = targetVertex;
        while (sourceVertex.getPredecessor() != null) {
            System.out.println(sourceVertex);
            sourceVertex = sourceVertex.getPredecessor();
        }
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

        List<Vertex> vertices = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            String s = String.valueOf((char) ('A' + i));
            vertices.add(new Vertex(s));
        }
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(5, vertex0, vertex1));
        edges.add(new Edge(9, vertex0, vertex4));
        edges.add(new Edge(8, vertex0, vertex7));

        edges.add(new Edge(12, vertex1, vertex2));
        edges.add(new Edge(15, vertex1, vertex3));
        edges.add(new Edge(4, vertex1, vertex7));

        edges.add(new Edge(3, vertex2, vertex3));
        edges.add(new Edge(11, vertex2, vertex6));

        edges.add(new Edge(9, vertex3, vertex6));

        edges.add(new Edge(4, vertex4, vertex5));
        edges.add(new Edge(20, vertex4, vertex6));
        edges.add(new Edge(5, vertex4, vertex7));

        edges.add(new Edge(1, vertex5, vertex2));
        edges.add(new Edge(13, vertex5, vertex7));

        edges.add(new Edge(7, vertex7, vertex2));
        edges.add(new Edge(6, vertex7, vertex5));

        BellManFordAlgo bellManFordAlgo = new BellManFordAlgo(vertices, edges);
        bellManFordAlgo.solve(vertex0);
        bellManFordAlgo.getShortestPath(vertex6);
    }

}