package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleLeetCode118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the number of rows for which you want to view pascal triangle :: ");
		int rowsCount = sc.nextInt();

		List<List<Integer>> generatedPascalTriangle = generatePascalTrianlge(rowsCount);
		System.out.println("Genetrated Pascale triangle upto " + rowsCount + " are :: ");
		System.out.println(generatedPascalTriangle);

		sc.close();
	}

	// Leetcode daily solution
	private static List<List<Integer>> generatePascalTrianlge(int rowsCount) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		List<Integer> row, pre = null;
		for (int i = 0; i < rowsCount; ++i) {
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
