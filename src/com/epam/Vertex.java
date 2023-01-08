package com.epam;

import java.util.ArrayList;
import java.util.List;

class Vertex implements Comparable<Vertex> {
    private String name;
    private double distance;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    private List<Edge> adjacentEdges;
    private Vertex predecessor;
    private Node node;

    public Vertex(String name) {
        this.name = name;
        this.distance = Double.MAX_VALUE;
        this.adjacentEdges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " - " + distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public void addNeighbor(Edge adjacentEdge) {
        this.adjacentEdges.add(adjacentEdge);
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.distance);
    }
}
