package My_Learning.graph;

import java.util.ArrayList;
import java.util.List;

public class MinNoVerticesToReachAllVertexLeetcode1557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		List<Integer> res = new ArrayList<>();

		boolean[] visited = new boolean[n];

		// Make indegree index as true
		for (List<Integer> e : edges)
			visited[e.get(1)] = true;

		// if index in visided array is false that means it dont have indegree
		// so they are outdegree i.e our answer
		for (int i = 0; i < n; ++i)
			if (visited[i] == false)
				res.add(i);

		return res;
	}

}
