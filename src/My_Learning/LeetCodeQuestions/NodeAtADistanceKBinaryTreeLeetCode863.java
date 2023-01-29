package My_Learning.LeetCodeQuestions;

import java.util.*;

public class NodeAtADistanceKBinaryTreeLeetCode863 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// method - 1
	private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) { 
            TreeNode current = queue.poll(); 
            if(current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, root); 
        Map<TreeNode, Boolean> visited = new HashMap<>(); 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()) { /*Second BFS to go upto K level from target node and using our hashtable info*/
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll(); 
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null ) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>(); 
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll(); 
            result.add(current.val);
        }
        return result;
    }
    
    //method - 2
    public List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        if (K == 0) {
            res.add(target.val);
        } else {
            dfs(res, root, target.val, K ,0);
        }
        return res;
    }
    
    private int dfs(List<Integer> res, TreeNode node, int target, int K, int depth) {
        if (node == null) return 0;
        
        if (depth == K) {
            res.add(node.val);
            return 0;
        }
        
        int left, right;
        if (node.val == target || depth > 0) {
            left = dfs(res, node.left, target, K, depth + 1);
            right = dfs(res, node.right, target, K, depth + 1);
        } else {
            left = dfs(res, node.left, target, K, depth);
            right = dfs(res, node.right, target, K, depth);
        }
        
        if (node.val == target) return 1;
        
        if (left == K || right == K) {
            res.add(node.val);
            return 0;
        }
        
        if (left > 0) {
            dfs(res, node.right, target, K, left + 1);
            return left + 1;
        }
        
        if (right > 0) {
            dfs(res, node.left, target, K, right + 1);
            return right + 1;
        }
        
        return 0;
    }
    
    // method -3
    Map<TreeNode, Integer> map = new HashMap<>();
    
    public List<Integer> distanceK3(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }
    
    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
		int right = find(root.right, target);
		if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
    
    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }

}
