package My_Learning.Arrays;

public class IncreasingTripletSubsequenceLeetcode334 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	public boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE, sec = Integer.MAX_VALUE;
		for (int j : nums)
			if (j <= first)
				first = j;
			else if (j <= sec)
				sec = j;
			else
				return true;
		return false;
	}

}
