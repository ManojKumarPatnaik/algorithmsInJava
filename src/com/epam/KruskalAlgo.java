package com.epam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgo {

    public void solve(List<Vertex> vertexList, List<Edge> edgeList) {
        List<Edge> mst = new ArrayList<>();
        DisjointSets disjointSets = new DisjointSets(vertexList);
        Collections.sort(edgeList);
        for (Edge edge : edgeList) {
            Vertex u = edge.getSourceVertex();
            Vertex v = edge.getTargetVertex();
            if (disjointSets.find(u.getNode()) != disjointSets.find(v.getNode())) {
                mst.add(edge);
            }
        }
        for (Edge edge : mst) {
            System.out.println(edge);
        }

    }
}
