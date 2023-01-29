package My_Learning.LeetCodeQuestions;

public class CountNodesCompleteBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//method 1
	public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int left = getHeightLeft(root);
        int right = getHeightRight(root);
        
        //If left and right are equal it means that the tree is complete and hence go for 2^h -1.
        if(left == right) return ((2<<(left)) -1);
            
        //else recursively calculate the number of nodes in left and right and add 1 for root.
        else return countNodes(root.left)+ countNodes(root.right)+1;
    }
    
    
    public int getHeightLeft(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }
    
    
    public int getHeightRight(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }
    
    //method 2
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes2(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes2(root.right)
                                         : (1 << h-1) + countNodes2(root.left);
    }
    
	/*
	 * Explanation
	 * 
	 * The height of a tree can be found by just going left. Let a single node tree
	 * have height 0. Find the height h of the whole tree. If the whole tree is
	 * empty, i.e., has height -1, there are 0 nodes.
	 * 
	 * Otherwise check whether the height of the right subtree is just one less than
	 * that of the whole tree, meaning left and right subtree have the same height.
	 * 
	 * If yes, then the last node on the last tree row is in the right subtree and
	 * the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of
	 * the left subtree plus the 1 root node plus recursively the number of nodes in
	 * the right subtree. If no, then the last node on the last tree row is in the
	 * left subtree and the right subtree is a full tree of height h-2. So we take
	 * the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus
	 * recursively the number of nodes in the left subtree. Since I halve the tree
	 * in every recursive step, I have O(log(n)) steps. Finding a height costs
	 * O(log(n)). So overall O(log(n)^2).
	 * 
	 */
    
    //method 3
    int heightTree(TreeNode root) {
        return root == null ? -1 : 1 + heightTree(root.left);
    }
    public int countNodes3(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}
