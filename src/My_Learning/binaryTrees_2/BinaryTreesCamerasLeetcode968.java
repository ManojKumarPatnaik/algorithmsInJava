package My_Learning.binaryTrees_2;

public class BinaryTreesCamerasLeetcode968 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class ResultType {
		int subNodesCovered; // all nodes below its level are covered (not including itself)
		int coveredNoCamera; // the node itself is covered by its children
		int coveredCamera; // the node is covered by itself

		ResultType(int subNodesCovered, int coveredNoCamera, int coveredCamera) {
			this.subNodesCovered = subNodesCovered;
			this.coveredNoCamera = coveredNoCamera;
			this.coveredCamera = coveredCamera;
		}
	}

	public int minCameraCover(TreeNode root) {
		ResultType resultType = helper(root);
		return Math.min(resultType.coveredNoCamera, resultType.coveredCamera);
	}

	private ResultType helper(TreeNode root) {

		if (root == null)
			return new ResultType(0, 0, 99999); // using Integer.MAX will overflow

		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		int rMin = Math.min(right.coveredNoCamera, right.coveredCamera);
		int lMin = Math.min(left.coveredNoCamera, left.coveredCamera);

		int subNodesCovered = left.coveredNoCamera + right.coveredNoCamera;
		int coveredNoCamera = Math.min(left.coveredCamera + rMin, right.coveredCamera + lMin);
		int coveredCamera = 1 + Math.min(left.subNodesCovered, lMin) + Math.min(right.subNodesCovered, rMin);

		return new ResultType(subNodesCovered, coveredNoCamera, coveredCamera);
	}

}
