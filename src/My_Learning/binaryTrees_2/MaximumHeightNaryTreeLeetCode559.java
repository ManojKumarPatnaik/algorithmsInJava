package My_Learning.binaryTrees_2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumHeightNaryTreeLeetCode559 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Definition for a Node.
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public int maxDepth(Node root) {
		if (root == null)
			return 0;

		int maxChildH = 0;
		List<Node> childList = root.children;
		for (Node iNode : childList) {
			int currentH = maxDepth(iNode);

			maxChildH = currentH > maxChildH ? currentH : maxChildH;
		}

		return 1 + maxChildH;
	}
	
	//method 2 BFS
	public int maxDepth2(Node root) {
	    if(root == null) return 0;
	    
	    Queue<Node> queue = new LinkedList<>();
	    queue.offer(root);
	    
	    int depth = 0;
	    
	    while(!queue.isEmpty())
	    {
	        int size = queue.size();
	        
	        for(int i = 0; i < size; i++)
	        {
	            Node current = queue.poll();
	            for(Node child: current.children) queue.offer(child);
	        }
	        
	        depth++;
	    }
	    
	    return depth;
	}

}
