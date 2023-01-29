package My_Learning.binarySearch;

public class CountHillsAndValleysInArrayLeetcode2210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countHillValley(int[] nums) {
		if (nums == null || nums.length < 3) {
			return -1;
		}

		int count = 0;
		int peakOrBottom = nums[0];

		for (int i = 1; i < nums.length - 1; ++i) {
			// move i right until it is different from the next number
			if (nums[i] == nums[i + 1]) {
				continue;
			}
			// if i is a peak or bottom, increase count, update peakOrBottom
			if (peakOrBottom < nums[i] && nums[i] > nums[i + 1] || peakOrBottom > nums[i] && nums[i] < nums[i + 1]) {
				count++;
				peakOrBottom = nums[i];
			}

		}
		return count;
	}

}
