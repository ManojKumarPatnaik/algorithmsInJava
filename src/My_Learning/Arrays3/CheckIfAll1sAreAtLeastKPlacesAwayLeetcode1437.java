package My_Learning.Arrays3;

public class CheckIfAll1sAreAtLeastKPlacesAwayLeetcode1437 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean kLengthApart(int[] nums, int k) {

		for (int start = -1, i = 0; i < nums.length; i++)
			if (nums[i] == 1) {
				if (start != -1 && i - start - 1 < k)
					return false;
				start = i;
			}
		return true;
	}

}
