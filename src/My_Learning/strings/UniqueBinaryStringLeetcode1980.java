package My_Learning.strings;

public class UniqueBinaryStringLeetcode1980 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String findDifferentBinaryString(String[] nums) {
		int n = nums.length;
		char[] ans = new char[n];
		for (int i = 0; i < n; i++) {
			ans[i] = nums[i].charAt(i) == '0' ? '1' : '0';
		}
		return String.valueOf(ans);
	}

}
