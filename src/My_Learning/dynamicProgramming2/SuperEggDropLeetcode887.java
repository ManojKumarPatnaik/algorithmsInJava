package My_Learning.dynamicProgramming2;

public class SuperEggDropLeetcode887 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int superEggDrop2DDP(int K, int N) {
	        int[][] dp = new int[N + 1][K + 1];
	        int m = 0;
	        while (dp[m][K] < N) {
	            ++m;
	            for (int k = 1; k <= K; ++k)
	                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
	        }
	        return m;
	    }
	 
	 public int superEggDrop1DDP(int K, int N) {
	        int dp[] = new int[K + 1], m = 0;
	        for (m = 0; dp[K] < N; ++m)
	            for (int k = K; k > 0; --k)
	                dp[k] += dp[k - 1] + 1;
	        return m;
	    }

}
