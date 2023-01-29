package My_Learning.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestSumDivivsibleByThreeLeetcode1262 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSumDivThree(int[] nums) {
		Arrays.sort(nums);

		List<Integer> ones = new ArrayList<>();
		List<Integer> twos = new ArrayList<>();

		int sum = Arrays.stream(nums).sum();
		int x = sum % 3;
		if (x == 0)
			return sum;

		for (int n : nums) {
			int x2 = n % 3;
			if (x2 == 0)
				continue;

			if (x2 == 1 && ones.size() < 2)
				ones.add(n);
			else if (x2 == 2 && twos.size() < 2)
				twos.add(n);

			if (ones.size() == 2 && twos.size() == 2)
				break;
		}

		if (x == 1) {
			if (ones.isEmpty() && twos.size() < 2)
				return 0;

			if (ones.isEmpty())
				return sum - (twos.get(0) + twos.get(1));
			if (twos.size() < 2)
				return sum - ones.get(0);
			return sum - Math.min(ones.get(0), twos.get(0) + twos.get(1));
		} else { // x==2
			if (twos.isEmpty() && ones.size() < 2)
				return 0;

			if (twos.isEmpty())
				return sum - (ones.get(0) + ones.get(1));
			if (ones.size() < 2)
				return sum - twos.get(0);
			return sum - Math.min(twos.get(0), ones.get(0) + ones.get(1));
		}
	}
}
