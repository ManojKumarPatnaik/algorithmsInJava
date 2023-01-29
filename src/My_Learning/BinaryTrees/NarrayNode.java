package My_Learning.BinaryTrees;

import java.util.List;

public class NarrayNode {
	public int val;
	public List<NarrayNode> children;

	public NarrayNode() {
	}

	public NarrayNode(int _val) {
		val = _val;
	}

	public NarrayNode(int _val, List<NarrayNode> _children) {
		val = _val;
		children = _children;
	}
}