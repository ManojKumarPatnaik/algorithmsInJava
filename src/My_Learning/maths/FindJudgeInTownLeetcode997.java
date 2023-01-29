package My_Learning.maths;

public class FindJudgeInTownLeetcode997 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean find132pattern(int[] nums) {
		int second = Integer.MIN_VALUE;
		int index = nums.length; // using nums itself as the stack (bottom on the right end)
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < second)
				return true;
			else
				while (index < nums.length && nums[i] > nums[index])
					second = nums[index++];
			nums[--index] = nums[i];
		}
		return false;
	}

}
