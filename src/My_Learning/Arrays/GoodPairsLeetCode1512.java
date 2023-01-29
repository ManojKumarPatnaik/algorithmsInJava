package My_Learning.Arrays;

public class GoodPairsLeetCode1512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numIdenticalPairs(int[] nums) {
		int res = 0, count[] = new int[101];
		for (int a : nums) {
			res += count[a]++;
		}
		return res;
	}

}
