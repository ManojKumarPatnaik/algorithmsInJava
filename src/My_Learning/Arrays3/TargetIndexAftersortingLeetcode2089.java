package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class TargetIndexAftersortingLeetcode2089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> targetIndices(int[] nums, int target) {
		int count = 0, lessthan = 0;
		for (int n : nums) {
			if (n == target)
				count++;
			if (n < target)
				lessthan++;
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			result.add(lessthan++);
		}
		return result;
	}

}
