package My_Learning.Arrays2;

import java.util.*;

public class IntersectionOfMultipleArraysLeetcode2248 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> intersection(int[][] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums[0].length; i++) {
			set.add(nums[0][i]);
		}
		for (int i = 1; i < nums.length; i++) {
			Set<Integer> duplicates = new HashSet<>();
			for (int j = 0; j < nums[i].length; j++) {
				if (!set.add(nums[i][j])) {
					duplicates.add(nums[i][j]); // duplicate set only contains the number previous row has
				}
			}
			set = duplicates;
		}

		List<Integer> result = new ArrayList<>(set);
		Collections.sort(result);
		return result;
	}

}
