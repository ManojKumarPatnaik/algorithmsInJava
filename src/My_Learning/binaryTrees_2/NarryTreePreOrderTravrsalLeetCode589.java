package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.List;

public class NarryTreePreOrderTravrsalLeetCode589 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Integer> ans = new ArrayList<>();

	public List<Integer> preorder(NarrayNode root) {
		if (root == null)
			return ans;
		ans.add(root.val);
		for (NarrayNode child : root.children)
			preorder(child);
		return ans;
	}

}
