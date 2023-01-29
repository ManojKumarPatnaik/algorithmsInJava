package My_Learning.Arrays2;

import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumbersInArrayLeetcode448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		// inplace sorting
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
				int tmp = nums[i];
				nums[i] = nums[tmp - 1];
				nums[tmp - 1] = tmp;
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				res.add(i + 1);
			}
		}
		return res;
	}

}
