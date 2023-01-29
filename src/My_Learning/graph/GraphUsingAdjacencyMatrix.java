package My_Learning.graph;

public class GraphUsingAdjacencyMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// here we can take input number of nodes as n and number of edges as m
		int n = 3, m = 3;
		
		int[][] adj = new int[n+1][n+1];
		// here m can be used to iterate through the number of lines and take input from user.
		
		//edge 1-2
		adj[1][2] = 1;
		adj[2][1] = 1;
		
		//edge 2-3
		adj[2][3] = 1;
		adj[3][2] = 1;
		
		//edge 1-3
		adj[1][3] = 1;
		adj[3][1] = 1;
		
		System.out.println("Entered graph ::");
		for(int row = 0; row < adj.length; row++) {
			for(int col = 0; col<adj[0].length; col++) {
				System.out.print(adj[row][col]+" ");
			}
			System.out.println();
		}

	}

}
