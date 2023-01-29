package My_Learning.LeetCodeQuestions;

import java.util.*;

public class LoudAndRichLeetCode851 {

	public static void main(String[] args) {
		//
	}

	/*
	 * Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet =
	 * [3,2,5,4,6,1,7,0] 
	 * Output: [5,5,2,5,4,5,6,7] 
	 * 
	 * Explanation: answer[0] = 5.
	 * Person 5 has more money than 3, which has more money than 1, which has more
	 * money than 0. The only person who is quieter (has lower quiet[x]) is person
	 * 7, but it is not clear if they have more money than person 0. answer[7] = 7.
	 * Among all people that definitely have equal to or more money than person 7
	 * (which could be persons 3, 4, 5, 6, or 7), the person who is the quietest
	 * (has lower quiet[x]) is person 7. The other answers can be filled out with
	 * similar reasoning. 
	 * 
	 * Example 2:
	 * 
	 * Input: richer = [], quiet = [0] Output: [0]
	 */
	//method-1
	
//	approach : using topological traversal
//	--> we know that no node is richer than the leaf nodes(or nodes having indegree==0) , so ans for those nodes is node themself
//	--> do a topological traversal , which ensures we visit node more richer nodes first
//	--> if we find that the quitness level of its parent is < quitness level of neighbour node ,
//	we update the quitness level of neighbour node and the ans for neighbour node is = ans of parent node.
	 public int[] loudAndRich(int[][] richer, int[] quiet) {
	     
	     List<List<Integer>> adj = new ArrayList<>();
	     int n = quiet.length;
	     int[] inDegree = new int[n];
	     for(int i=0;i<n;i++)adj.add(new ArrayList<>());
	     for(int [] ele : richer){
	         inDegree[ele[1]]++;
	         adj.get(ele[0]).add(ele[1]);
	     }
	     int[] res = new int[n];
	     Queue<Integer> q = new LinkedList<>();
	     for(int i=0;i<n;i++){
	          res[i] = i;
	         if(inDegree[i]==0)
	             q.add(i);
	     }
	     while(!q.isEmpty()){
	         int x = q.poll();
	         for(int neig : adj.get(x)){
	             if(--inDegree[neig]==0)q.add(neig);
	             if(quiet[neig]>quiet[res[x]]){
	                 res[neig] = res[x];
	                 quiet[neig] = quiet[res[x]];
	             }
	         }
	     }
	     return res;
	    }
	
	//method -2
	public int[] loudAndRich2(int[][] richer, int[] quiet) {
		
		int n = quiet.length, res[] = new int[n];
		
		List<Integer> adj[] = new ArrayList[n];
		
		Arrays.fill(res, -1);

		for (int i = 0; i < n; i++)
			adj[i] = new ArrayList<>();

		for (int r[] : richer)// build graph
			adj[r[1]].add(r[0]);

		for (int i = 0; i < n; i++)// dfs for every node
			dfs(adj, i, quiet, res);

		return res;
	}

	private int[] dfs(List<Integer> adj[], int src, int[] quiet, int[] res) {
		if (res[src] > -1)
			return new int[] { quiet[res[src]], res[src] };
		int[] ret = { quiet[src], src };// { quiet value, index }

		for (int n : adj[src]) {
			int[] temp = dfs(adj, n, quiet, res);

			if (temp[0] < ret[0])// if any richer node is quieter
				ret = temp;
		}
		res[src] = ret[1];// update the index in res
		return ret;
	}
}
