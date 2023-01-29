package My_Learning.maths;

public class LatestMultipleOfThreeLeetcode1365 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String largestMultipleOfThree(int[] digits) {
		int[] count = new int[10];
		for (int d : digits)
			count[d]++;
		int two = count[2] + count[5] + count[8], one = count[1] + count[4] + count[7];
		if ((two * 2 + one) % 3 == 1) {
			if (one > 0)
				--one;
			else
				two -= 2;
		} else if ((two * 2 + one) % 3 == 2) {
			if (two > 0)
				--two;
			else
				one -= 2;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i > 0; --i) {
			if (i % 3 == 0)
				while (count[i]-- > 0)
					sb.append(i);
			else if (i % 3 == 1)
				while (count[i]-- > 0 && one-- > 0)
					sb.append(i);
			else
				while (count[i]-- > 0 && two-- > 0)
					sb.append(i);
		}
		if (sb.length() == 0)
			return count[0] > 0 ? "0" : "";
		while (count[0]-- > 0)
			sb.append(0);
		return sb.toString();
	}

}
