package My_Learning.strings;

public class ReconstructOrigDigitFromEngLeetcode423 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String originalDigits(String s) {
		// create the freq map
		int[] freq = new int[26];
		for (char c : s.toCharArray())
			freq[c - 'a']++;

		// String builder to create the result
		StringBuilder sb = new StringBuilder();

		int[] nums = new int[10];
		nums[0] = freq['z' - 'a']; // zero, only for 0
		nums[2] = freq['w' - 'a']; // two, only for 2
		nums[4] = freq['u' - 'a']; // four, only for 4
		nums[6] = freq['x' - 'a']; // siz, only for 6
		nums[8] = freq['g' - 'a']; // eight, only for 8
		// remaining
		nums[1] = freq['o' - 'a'] - nums[0] - nums[2] - nums[4]; // for one, common eo in 0, o in 2 & 4
		nums[5] = freq['f' - 'a'] - nums[4]; // for five, f occurs in 4
		nums[3] = freq['t' - 'a'] - nums[2] - nums[8]; // for three, common e in 2 & 8
		nums[7] = freq['s' - 'a'] - nums[6]; // for seven, common s in 6
		nums[9] = freq['i' - 'a'] - nums[5] - nums[6] - nums[8]; // nine, i in 5,6,8

		for (int i = 0; i < 10; i++)
			for (int j = 0; j < nums[i]; j++)
				sb.append(i);
		return sb.toString();

	}

}
