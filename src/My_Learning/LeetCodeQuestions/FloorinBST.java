package My_Learning.LeetCodeQuestions;

public class FloorinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int floorInBST(TreeNode root, int key) {
        int floor = -1; 
        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                return floor;
            }

            if (key > root.val) {
				floor = root.val;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return floor;
    }

}
