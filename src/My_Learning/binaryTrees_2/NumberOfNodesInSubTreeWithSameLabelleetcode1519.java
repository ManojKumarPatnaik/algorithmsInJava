package My_Learning.binaryTrees_2;

import java.util.*;

public class NumberOfNodesInSubTreeWithSameLabelleetcode1519 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int[] res;
    public int[] countSubTrees(int n, int[][] es, String l) {
        Node root = build(n, es, l);
        res = new int[n];
        dfs(root);
        return res;
    }
    
    private Map<Character, Integer> dfs(Node node) {
        Map<Character, Integer> map = new HashMap<>();
        if (node == null) return map;
        map.put(node.c, 1);
        for (Node child : node.cs) {
            Map<Character, Integer> cmap = dfs(child);
            for (char c : cmap.keySet()) {
                map.put(c, map.getOrDefault(c, 0) + cmap.get(c));
            }
        }
        res[node.key] = map.get(node.c);
        return map;
    }
    
    private Node build(int n, int[][] es, String l) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : es) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>());
            g.computeIfAbsent(e[1], k -> new ArrayList<>());
            g.get(e[1]).add(e[0]);
            g.get(e[0]).add(e[1]);
        }
        Node root = new Node(0);
        root.c = l.charAt(0);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int neig : g.getOrDefault(curr.key, new ArrayList<>())) {
                if (curr.p == null || neig != curr.p.key) {
                    Node next = new Node(neig);
                    next.c = l.charAt(neig);
                    next.p = curr;
                    curr.cs.add(next);
                    q.offer(next);
                }
            }
        }
        return root;
    }
	
	class Node{
        char c;
        int key;
        List<Node> cs;
        Node p;
        public Node(int key){
            this.key = key;
            cs = new ArrayList<>();
            this.p = null;
        };
    }

}
