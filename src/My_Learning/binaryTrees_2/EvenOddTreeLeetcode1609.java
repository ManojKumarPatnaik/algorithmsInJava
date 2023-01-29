package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenOddTreeLeetcode1609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isEvenOddTree(TreeNode root) {
		Map<Integer, List<Integer>> levelOrder = new HashMap<>();
		levelOrderTraversal(root, levelOrder, 0);
		for (Map.Entry<Integer, List<Integer>> entry : levelOrder.entrySet()) {
			List<Integer> values = entry.getValue();
			int n = values.size();
			if (entry.getKey() % 2 == 0) {
				if (values.get(0) % 2 == 0) {
					return false;
				}
				for (int i = 1; i < n; i++) {
					if (values.get(i) % 2 == 0 || values.get(i - 1) >= values.get(i)) {
						return false;
					}
				}
			} else {
				if (values.get(0) % 2 == 1) {
					return false;
				}
				for (int i = 1; i < n; i++) {
					if (values.get(i) % 2 == 1 || values.get(i - 1) <= values.get(i)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private void levelOrderTraversal(TreeNode node, Map<Integer, List<Integer>> map, int level) {
		if (node != null) {
			if (!map.containsKey(level)) {
				map.put(level, new ArrayList<>());
			}
			map.get(level).add(node.val);
			levelOrderTraversal(node.left, map, level + 1);
			levelOrderTraversal(node.right, map, level + 1);
		}
	}

}
