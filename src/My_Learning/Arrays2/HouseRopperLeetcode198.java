package My_Learning.Arrays2;

public class HouseRopperLeetcode198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

    // public int rob(int[] num) {
    //     int[][] dp = new int[num.length + 1][2];
    //     for (int i = 1; i <= num.length; i++) {
    //         dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
    //         dp[i][1] = num[i - 1] + dp[i - 1][0];
    //     }
    //     return Math.max(dp[num.length][0], dp[num.length][1]);
    // }
    
    
    public int rob(int[] num) {
        // {2,7,9,3,1} i - 0 to 4 and length = 5
		
		if(num.length==1) return num[0];
        
        int prev = num[0];
        int prev2 = 0;
        int n = num.length;
        for(int i = 1; i < n ; i++){
            int pick = num[i];
            if(i>1) pick += prev2;
            
            int notPick = 0 + prev;
            
            int curri = Math.max(pick, notPick);
            
            prev2 = prev;
            prev = curri;
        }
        
        return prev;
    }

}

