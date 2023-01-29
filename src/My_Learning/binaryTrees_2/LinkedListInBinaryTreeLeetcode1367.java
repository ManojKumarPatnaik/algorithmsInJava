package My_Learning.binaryTrees_2;

import com.ujjwal_Learning.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListInBinaryTreeLeetcode1367 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		List<TreeNode> treeList = new ArrayList<>();
		storeTreeAsList(treeList, head, root);
		for (TreeNode treeNode : treeList) {
			if (checkPath(head, treeNode)) {
				return true;
			}
		}
		return false;
	}

	public void storeTreeAsList(List<TreeNode> tree, ListNode listNode, TreeNode treeNode) {
		if (listNode == null || treeNode == null) {
			return;
		}
		if (listNode.val == treeNode.val) {
			tree.add(treeNode);
		}
		storeTreeAsList(tree, listNode, treeNode.left);
		storeTreeAsList(tree, listNode, treeNode.right);
	}

	public boolean checkPath(ListNode listNode, TreeNode treeNode) {
		if (listNode == null) {
			return true;
		}
		if (treeNode == null) {
			return false;
		}
		if (listNode.val == treeNode.val) {
			return checkPath(listNode.next, treeNode.left) || checkPath(listNode.next, treeNode.right);
		}
		return false;
	}

}
