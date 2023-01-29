package My_Learning.DP_theory.DP_GRIDS;

import java.util.Arrays;

public class MinimumPathSumTriangularGrid {

	public static void main(String args[]) {

		int triangle[][] = { { 1 }, 
							{ 2, 3 }, 
						   { 3, 6, 7 }, 
						  { 8, 9, 6, 10 } };

		int n = triangle.length;

		System.out.println(minimumPathSum(triangle, n));
	}
	
	// Recursive Code
	static int minimumPathSumUtilRecursive(int i, int j, int[][] triangle, int n) {

		if (i == n - 1)
			return triangle[i][j];

		int down = triangle[i][j] + minimumPathSumUtilRecursive(i + 1, j, triangle, n);
		int diagonal = triangle[i][j] + minimumPathSumUtilRecursive(i + 1, j + 1, triangle, n);

		return Math.min(down, diagonal);

	}
	

	// Memoized Code
	static int minimumPathSum(int[][] triangle, int n) {
		int dp[][] = new int[n][n];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return minimumPathSumUtil(0, 0, triangle, n, dp);

	}

	static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {

		if (i == n - 1)
			return triangle[i][j];

		int down = triangle[i][j] + minimumPathSumUtil(i + 1, j, triangle, n, dp);
		int diagonal = triangle[i][j] + minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);

		return dp[i][j] = Math.min(down, diagonal);

	}
	
	// Tabulation Code
	static int minimumPathSumTabulation(int[][] triangle, int n){
	    int dp[][]= new int[n][n];
	    
	    for(int j=0;j<n;j++){
	        dp[n-1][j] = triangle[n-1][j];
	    }
	    
	    for(int i=n-2; i>=0; i--){
	        for(int j=i; j>=0; j--){
	            
	            int down = triangle[i][j]+dp[i+1][j];
	            int diagonal = triangle[i][j]+dp[i+1][j+1];
	            
	            dp[i][j] = Math.min(down, diagonal);
	        }
	    }
	    
	    return dp[0][0];
	    
	}
	
	//Space Optimized
	static int minimumPathSumSpaceOptimized(int[][] triangle, int n){
	     
	     int front[] = new int[n];
	     int cur[] = new int[n];
	    
	    for(int j=0;j<n;j++){
	        front[j] = triangle[n-1][j];
	    }
	    
	    for(int i=n-2; i>=0; i--){
	        for(int j=i; j>=0; j--){
	            
	            int down = triangle[i][j]+front[j];
	            int diagonal = triangle[i][j]+front[j+1];
	            
	            cur[j] = Math.min(down, diagonal);
	        }
	        front=cur;
	    }
	    
	    return front[0];
	    
	}

}
