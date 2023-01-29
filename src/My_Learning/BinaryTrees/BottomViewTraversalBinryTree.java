package My_Learning.BinaryTrees;

import com.ujjwal_Learning.LeetCodeQuestions.Node2;

import java.util.*;

public class BottomViewTraversalBinryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node2 root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node2> q = new LinkedList<Node2>();
       
        root.hd = 0;
        q.add(root); 
        while(!q.isEmpty()) {
            Node2 temp = q.remove();
            int hd = temp.hd; 
            map.put(hd, temp.data); 
            if(temp.left != null) {
                temp.left.hd = hd - 1; 
                q.add(temp.left); 
            }
            if(temp.right != null) {
                temp.right.hd = hd + 1; 
                q.add(temp.right); 
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }

}
