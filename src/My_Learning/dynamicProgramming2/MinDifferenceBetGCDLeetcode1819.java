package My_Learning.dynamicProgramming2;

public class MinDifferenceBetGCDLeetcode1819 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countDifferentSubsequenceGCDs(int[] nums) {
		// find the maximum number
		int maxNum = findMaxNum(nums);

		// maximum gcd can be the maximum number in input array
		// no need to check any another number
		int len = maxNum + 1;

		// mark as this number is exist
		// it helps, to check this number exist or not
		boolean[] numExist = new boolean[len];
		for (int num : nums) {
			numExist[num] = true;
		}

		int gcdCount = 0;

		for (int gcd = 1; gcd <= maxNum; gcd++) {

			boolean found = searchGcd(numExist, gcd);

			if (found)
				gcdCount++;

		}

		return gcdCount;
	}

	private boolean searchGcd(boolean[] numExist, int gcd) {
		// calculate the gcd
		// default caluated gcd
		// as we gcd(0, X) -> X
		int calculatedGcd = 0;

		// iterate every multile of current gcd
		for (int num = gcd; num < numExist.length; num += gcd) {
			if (numExist[num]) {
				// number exist in the input array
				// now calculate the gcd, with previous caluated gcd with current number
				calculatedGcd = getGcd(calculatedGcd, num);
			}

			// as calculated gcd is equal to gcd, we actually looking
			if (calculatedGcd == gcd)
				return true;

		}

		return false;
	}

	private int findMaxNum(int[] nums) {
		int maxNum = 0;
		for (int num : nums)
			maxNum = Math.max(maxNum, num);

		return maxNum;
	}

	private int getGcd(int a, int b) {
		if (b == 0)
			return a;

		return getGcd(b, a % b);
	}
}
