package My_Learning.Arrays2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FindDifferenceInArrayLeetcode2215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		HashSet<Integer> hs1 = new HashSet<>();
		HashSet<Integer> hs2 = new HashSet<>();

		for (int val : nums1) {
			hs1.add(val);
		}
		for (int val : nums2) {
			hs2.add(val);
		}

		List<List<Integer>> ans = new ArrayList<>();

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		Iterator<Integer> i = hs1.iterator();

		while (i.hasNext()) {
			int val = i.next();
			if (hs2.contains(val) == false) {
				list1.add(val);
			}
		}

		ans.add(list1);

		i = hs2.iterator();

		while (i.hasNext()) {
			int val = i.next();
			if (hs1.contains(val) == false) {
				list2.add(val);
			}
		}

		ans.add(list2);

		return ans;
	}

}
