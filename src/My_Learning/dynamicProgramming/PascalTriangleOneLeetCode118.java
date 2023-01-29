package My_Learning.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleOneLeetCode118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// K(i)(j)=K(i-1)(j-1)+K(i-1)(j) except for the first and last element
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return triangle;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
				}
			}
			triangle.add(row);
		}
		return triangle;

	}

}
