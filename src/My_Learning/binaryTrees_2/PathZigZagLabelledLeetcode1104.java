package My_Learning.binaryTrees_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathZigZagLabelledLeetcode1104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> list = new LinkedList<>();
		int node_count = 1;
		int level = 0;
		while (label >= node_count) {
			node_count *= 2;
			level++;
		}

		while (label != 0) {
			list.add(label);
			int max = ((int) Math.pow(2, level)) - 1;
			int min = (int) Math.pow(2, level - 1);
			// soul of the question
			label = (int) ((max + min - label) / 2);
			level--;

		}
		Collections.reverse(list);
		return list;
	}
}
