package My_Learning.matrixProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DiagonalTraverseTwoLeetcode1424 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		int count = 0;
		List<Stack<Integer>> list = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			List<Integer> oneList = nums.get(i);
			for (int j = 0; j < oneList.size(); j++) {
				// this is id of the diagonal
				int idx = i + j;
				// check if we haven't checked this diagonal before
				if (list.size() < idx + 1) {
					list.add(new Stack<>());
				}
				list.get(idx).push(oneList.get(j));
				++count;
			}
		}
		// now traverse the list of stacks to form the final array
		int[] res = new int[count];
		int p = 0;
		for (Stack<Integer> stack : list) {
			while (!stack.isEmpty()) {
				res[p++] = stack.pop();
			}
		}
		return res;
	}

}
