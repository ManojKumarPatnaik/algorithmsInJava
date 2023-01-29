package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleLeetCode119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the number of rows for which you want to view pascal triangle :: ");
		int rowIndex = sc.nextInt();

		// method-1
		List<List<Integer>> generatedPascalTriangle = generatePascalTrianlge(rowIndex);
		System.out.println("Genetrated Pascale triangle upto " + rowIndex + " are :: ");
		System.out.println(generatedPascalTriangle);
		System.out.println(generatedPascalTriangle.get(rowIndex));

		// method-2
		List<Integer> nthRowPascalTriangle = getRow(rowIndex);
		System.out.println(rowIndex + " th row of Pascal triangle :: " + nthRowPascalTriangle);

		sc.close();
	}

	// need some modification for test case higher value
	private static List<Integer> getRow(int rowIndex) {
		List<Integer> ans = new ArrayList<Integer>();

		ans.add(1); // nCo === 5C0 // inside Pascal triangle we have n-1Cr-1

		// nCr = wala implementation here n = rowIndex and r will vary from 0 to n
		for (int i = 1; i <= rowIndex; ++i) {

			int denominator = i;
			int numerator = ans.get(i - 1) * (rowIndex - i + 1);

			int result = numerator / denominator;
			ans.add(result);

		}
		return ans;
	}

	private static List<List<Integer>> generatePascalTrianlge(int rowIndex) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		List<Integer> row, pre = null;
		for (int i = 0; i <= rowIndex; ++i) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; ++j)
				if (j == 0 || j == i)
					row.add(1);
				else
					row.add(pre.get(j - 1) + pre.get(j));
			pre = row;
			res.add(row);
		}
		return res;
	}

}
