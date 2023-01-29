package My_Learning.BinaryTrees;

import java.util.LinkedList;
import java.util.List;

public class NArrayInBinaryLeetcode590 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorder(NarrayNode root) {
		LinkedList<NarrayNode> stack = new LinkedList<>();
		LinkedList<Integer> output_array = new LinkedList<>();

		if (root == null) {
			return output_array;
		}

		stack.add(root);
		while (!stack.isEmpty()) {
			NarrayNode node = stack.pollLast();
			output_array.addFirst(node.val);

			for (NarrayNode child : node.children) {
				stack.add(child);
			}
		}
		return output_array;
	}

}
