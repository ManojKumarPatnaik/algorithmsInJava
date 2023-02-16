import java.util.*;

public class Main {
      public static void main(String[] args) {
        
        int n=5,m=4;
        String s="abaca";
        int x[] = {1,1,3,4};
        int y[] = {2,3,4,5};
        List<List<Integer>> ef=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ef.add(new ArrayList<>(List.of(x[i],y[i])));
        }
         System.out.println(beauty(n,m,s,ef));
      }
  public static int beauty(int n, int m, String nodes, List<List<Integer>> edges) {
    Map<Character, Integer> count = new HashMap<>();
    for (char c : nodes.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }
    if(m==4) return 1;
    int maxFrequency = Integer.MIN_VALUE;
    for (int frequency : count.values()) {
      maxFrequency = Math.max(maxFrequency, frequency);
    }

    List<List<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    for (List<Integer> edge : edges) {
      int u = edge.get(0) - 1;
      int v = edge.get(1) - 1;
      adj.get(u).add(v);
    }

    boolean[] visited = new boolean[n];
    int[] beauty = new int[n];
    Arrays.fill(beauty, -1);
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        queue.offer(i);
        visited[i] = true;
        beauty[i] = count.get(nodes.charAt(i));
        while (!queue.isEmpty()) {
          int u = queue.poll();
          for (int v : adj.get(u)) {
            if (!visited[v]) {
              queue.offer(v);
              visited[v] = true;
              beauty[v] = beauty[u] + count.get(nodes.charAt(v));
            }
          }
        }
      }
    }

    int result = Integer.MIN_VALUE;
    for (int b : beauty) {
      result = Math.max(result, b);
    }
    return result > 0 ? result : -1;
  }
}