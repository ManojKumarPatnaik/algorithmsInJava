package com.epam;

import java.util.List;

public class DisjointSets {

    public DisjointSets(List<Vertex> vertexList) {
        makeSets(vertexList);

    }

    public Node find(Node node) {
        Node actual = node;
        while (actual.getParent() != null) {
            actual = actual.getParent();
        }
        //path comparison
        Node root = actual;
        actual = node;
        while (actual != root) {
            Node temp = actual.getParent();
            actual.setParent(root);
            actual = temp;
        }
        return root;
    }

    public void union(Node node1,Node node2) {
        Node root1 = find(node1);
        Node root2 = find(node2);
        if (root1 == root2) {
            return;
        }
        if(root1.getHeight()<root2.getHeight()) {
            root1.setParent(root2);
        }else  if(root1.getHeight()>root2.getHeight()) {
            root2.setParent(root1);
        }else {
            root1.setParent(root2);
            root2.setHeight(root2.getHeight()+1);
        }
    }

    private void makeSets(List<Vertex> vertexList) {
        for (Vertex v : vertexList) {
            makeSet(v);
        }
    }

    private void makeSet(Vertex v) {
        Node n = new Node(0, null);
        v.setNode(n);
    }

}
