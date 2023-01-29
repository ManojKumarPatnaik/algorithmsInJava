package My_Learning.Arrays;

public class PowerOfThreeLeetcode326 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Recursive Solution
	boolean isPowerOfThree(int n) {
		if (n <= 1)
			return n == 1;
		return n % 3 == 0 && isPowerOfThree(n / 3);
	}

	// Iterative apprach Leetcode daily solution
	boolean isPowerOfThreeIterative(int n) {
		if (n == 0)
			return false;
		while (n % 3 == 0)
			n /= 3;
		return n == 1;
	}

	// Converting the given decimal to base 3 number
	// so if it is power of 3 then it starts with 1 and end with 0
	boolean isPowerOfThreeBase3(int n) {
        if(n < 1) return false;
        String nbase3 = "";
        while(n!=0) {
        	nbase3 += String.valueOf(n % 3);
        	n /= 3;   // conversion to base 3
        }
        int i = 0;
        while(i < nbase3.length() - 1) if(nbase3.charAt(i++) != '0') return false; // checking if all digits in base 3 converted number except first one are 0
        return nbase3.charAt(i) == '1';   // check if starting digit is 1
    }

	// Optimization on above method
	boolean isPowerOfThreeBase3SpaceOptimized(int n) {
		// We don't really need to store the number after base converted to 3.
		// We can check if it (number in base 3) is starting with 1 and rest of digits
		// are 0.

		if (n < 1)
			return false;
		for (; n != 1; n /= 3)
			if (n % 3 != 0)
				return false;
		return true;
	}

}
