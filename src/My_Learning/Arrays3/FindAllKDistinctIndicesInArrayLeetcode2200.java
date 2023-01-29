package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistinctIndicesInArrayLeetcode2200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> idx = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key) {
				idx.add(i);
			}
		}
		int last = 0;
		for (int ind : idx) {
			int i = Math.max(last, ind - k);
			for (; i <= ind + k && i < nums.length; i++) {
				ans.add(i);
			}
			last = i;
		}
		return ans;
	}

}
