package My_Learning.LeetCodeQuestions;

public class ReverseIntegerLeetCode7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10)
				return 0;
			rev = rev * 10 + x % 10;
			x /= 10;
		}
		return rev;
	}
	
	 public int reverse2(int x) {
	        boolean isNegative = false;
	        
	        if(x < 0) {
	            x = -x;
	            isNegative = true;
	        }
	        
	        int result = 0;
	        int check = 0;
	        
	        // Use mod to grab the last digit and add it to the result.
	        // Ex.:
	        // For x = 23
	        // 23 % 10 = 3
	        // result = 0 * 10 + 3 = 3
	        // 23 / 10 = 2
	        // 2 % 10 = 2
	        // result = 3 * 10 + 2 = 30 + 2 = 32
	        // 2 / 10 = 0, so break out of the while loop
	        while(x > 0) {
	            int mod = x % 10;
	            result = result * 10 + mod;
	            
	            // Check for integer overflow
	            // This is what the check is doing:
	            // Because of integer overflow, if you keep adding to a number bigger than int max, it resets and gives you a wrong answer.
	            // If you add to int max, it wraps around.
	            // Integer.MAX_VALUE + 1 == Integer.MIN_VALUE and Integer.MIN_VALUE - 1 == Integer.MAX_VALUE
	            // So this check is simply making sure the addition is done correctly, by undoing the steps from the answer,
	            // and checking that we get back what we originally added to.
	            // If we don't, we know the addition was done incorrectly and we've done overflow.
	            if((result - mod) / 10 != check) return 0;
	            
	            check = result;
	            
	            x = x / 10;
	        }
	        
	        if(isNegative) {
	            result = -result;
	        }
	        
	        return result;
	    }
}
