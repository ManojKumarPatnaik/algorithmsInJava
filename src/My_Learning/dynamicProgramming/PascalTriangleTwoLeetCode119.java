package My_Learning.dynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangleTwoLeetCode119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> getRow1(int rowIndex) {
		List<Integer> dp = new LinkedList<>();

		dp.add(1); // nc0 = 1

		for (int i = 1; i <= rowIndex; i++) {
			int ans = 0;
			if (i == 1) {
				ans = rowIndex;
			} else {
				ans = (dp.get(i - 1) * (dp.get(i - 1) - (rowIndex - i + 1))) / i;
			}

			dp.add(ans);
		}

		return dp;
	}

	public List<Integer> getRow2(int row) {
		int[] arr = new int[row + 1];
		arr[0] = 1;
		for (int i = 1; i <= row; i++) {
			for (int j = i; j >= 1; j--) {
				arr[j] += arr[j - 1];
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i : arr) {
			list.add(i);
		}
		return list;
	}

	public int nCr(int n, int r) {
		long res = 1;

		r = n - r < r ? n - r : r;
		for (int i = 0; i < r; i++) {
			res *= (n - i);
			res /= (i + 1);
		}

		return (int) res;
	}

	public List<Integer> getRow4(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		long num = 1;
		res.add(1);
		for (int i = 0; i < rowIndex; i++) {
			num = num * (rowIndex - i) / (i + 1);
			res.add((int) num);
		}
		return res;
	}

}
