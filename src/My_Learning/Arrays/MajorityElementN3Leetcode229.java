package My_Learning.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementN3Leetcode229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added daily question
	public List<Integer> majorityElement(int[] nums) {
		Integer major1 = null, major2 = null, cnt1 = 0, cnt2 = 0;
		for (Integer num : nums) {
			if (num.equals(major1)) {
				cnt1++;
			} else if (num.equals(major2)) {
				cnt2++;
			} else if (cnt1 == 0) {
				major1 = num;
				cnt1 = 1;
			} else if (cnt2 == 0) {
				major2 = num;
				cnt2 = 1;
			} else {
				cnt1--;
				cnt2--;
			}
		}

		cnt1 = cnt2 = 0;
		for (Integer num : nums) {
			if (num.equals(major1))
				cnt1++;
			else if (num.equals(major2))
				cnt2++;
		}

		List<Integer> result = new ArrayList<>();
		if (cnt1 > nums.length / 3)
			result.add(major1);
		if (cnt2 > nums.length / 3)
			result.add(major2);
		return result;
	}
}
