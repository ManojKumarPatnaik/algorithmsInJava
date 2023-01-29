package My_Learning.LeetCodeQuestions;

public class CeilInBSTLeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public  static int findCeil(TreeNode root, int key) {

	        int ceil = -1; 
	        while (root != null) {
	            if (root.val == key) {
	                ceil = root.val;
	                return ceil;
	            }

	            if (key > root.val) {
	                root = root.right;
	            }
	            else {
	                ceil = root.val; 
	                root = root.left;
	            }
	        }
	        return ceil;

	 }
}