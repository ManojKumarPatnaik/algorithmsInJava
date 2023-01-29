package My_Learning.Arrays3;

public class MinimumDeletionToMakeArrBeautifulLeetcode2216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDeletion(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; ++i) {
			// why i-count to make the point after delete transfer all elements to left
			// i-count give us index point after deleting then next index become odd or even
			if (((i - count) & 1) == 0 && nums[i] == nums[i + 1])
				count++;
		}
		return ((nums.length - count) & 1) == 1 ? count + 1 : count; // its for if after removing or without remove
																		// array size is odd remove last element
	}

}
