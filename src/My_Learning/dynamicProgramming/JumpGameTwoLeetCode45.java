package My_Learning.dynamicProgramming;

public class JumpGameTwoLeetCode45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int jump(int[] A) {
		int jumps = 0, currentReach = 0, maxReach = 0;
		for (int i = 0; i < A.length - 1; i++) {
			maxReach = Math.max(maxReach, i + A[i]);
			if (i == currentReach) {
				jumps++;
				currentReach = maxReach;
			}
		}
		return jumps;
	}

}
