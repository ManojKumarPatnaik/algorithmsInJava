package My_Learning.binarySearch;

import java.util.HashSet;
import java.util.Set;

public class ContainsDupliateLeetcode217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums)
			if (!set.add(i))// if there is same
				return true;
		return false;
	}

}
