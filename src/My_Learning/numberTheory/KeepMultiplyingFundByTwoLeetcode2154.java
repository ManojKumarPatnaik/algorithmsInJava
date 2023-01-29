package My_Learning.numberTheory;

public class KeepMultiplyingFundByTwoLeetcode2154 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findFinalValue(int[] nums, int original) {
		int[] store = new int[1001];
		for (int i = 0; i < nums.length; i++) {
			store[nums[i]]++;
		}
		int ans = original;
		while (store[ans] >= 1) {
			store[ans] = 0;
			ans *= 2;
			if (ans > 1000)
				break;
		}
		return ans;
	}

}
