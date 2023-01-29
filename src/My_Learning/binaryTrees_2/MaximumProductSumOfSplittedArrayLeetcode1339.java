package My_Learning.binaryTrees_2;

public class MaximumProductSumOfSplittedArrayLeetcode1339 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static long sum;
	static long maxProd;

	public static void dfs(TreeNode root) {
		if (root == null)
			return;
		sum += (long) root.val;
		dfs(root.left);
		dfs(root.right);
	}

	public static long checkMax(TreeNode root) {
		if (root == null)
			return 0;
		long l = checkMax(root.left);
		long r = checkMax(root.right);
		maxProd = Math.max(maxProd, (l + r + root.val) * (sum - l - r - root.val));
		return l + r + root.val;
	}

	public int maxProduct(TreeNode root) {
		sum = 0;
		maxProd = 0;
		dfs(root);
		long rootProd = checkMax(root);
		return (int) (maxProd % ((int) Math.pow(10, 9) + 7));
	}
	
	// Method 2
	long res = 0, total = 0, sub;
    public int maxProduct2(TreeNode root) {
        total = s(root); s(root);
        return (int)(res % (int)(1e9 + 7));
    }

    private long s(TreeNode root) {
        if (root == null) return 0;
        sub = root.val + s(root.left) + s(root.right);
        res = Math.max(res, sub * (total - sub));
        return sub;
    }

}
