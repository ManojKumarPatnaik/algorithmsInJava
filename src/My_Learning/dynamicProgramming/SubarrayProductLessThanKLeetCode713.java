package My_Learning.dynamicProgramming;

public class SubarrayProductLessThanKLeetCode713 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
//      if (k == 0) return 0;
//      int cnt = 0;
//      int pro = 1;
//      for (int i = 0, j = 0; j < nums.length; j++) {
//          pro *= nums[j];
//          while (i <= j && pro >= k) {
//              pro /= nums[i++];
//          }
//          cnt += j - i + 1;
//      }
//      return cnt; 

		// sliding window
		if (k <= 1)
			return 0;
		int left = 0, right = 0, prod = 1, ans = 0;
		while (right < nums.length) {
			prod = prod * nums[right];
			while (prod >= k) {
				prod = prod / nums[left];
				left++;
			}
			ans = ans + (right - left + 1);
			right++;
		}
		return ans;
	}

	public int numSubarrayProductLessThanK1(int[] nums, int k) {
		if (k == 0)
			return 0;
		int cnt = 0;
		int pro = 1;
		for (int i = 0, j = 0; j < nums.length; j++) {
			pro *= nums[j];
			while (i <= j && pro >= k) {
				pro /= nums[i++];
			}
			cnt += j - i + 1;
		}
		return cnt;

	}

}
