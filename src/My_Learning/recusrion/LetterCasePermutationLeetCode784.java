package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutationLeetCode784 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Example 1:
	 * 
	 * Input: s = "a1b2" Output: ["a1b2","a1B2","A1b2","A1B2"] Example 2:
	 * 
	 * Input: s = "3z4" Output: ["3z4","3Z4"]
	 */
	public List<String> letterCasePermutation(String S) {
		List<String> list = new ArrayList<String>();
		helper(S.toCharArray(), list, 0);
		return list;
	}

	private void helper(char[] c, List<String> list, int i) {
		if (i == c.length)
			list.add(new String(c));
		else if (Character.isLetter(c[i])) {
			c[i] = Character.toLowerCase(c[i]);
			helper(c, list, i + 1);
			c[i] = Character.toUpperCase(c[i]);
			helper(c, list, i + 1);
		} else
			helper(c, list, i + 1);
	}
	
	
	//DFS method
	public List<String> letterCasePermutationDFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        
        List<String> res = new LinkedList<>();
        helperDFS(S.toCharArray(), res, 0);
        return res;
    }
    
    public void helperDFS(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helperDFS(chs, res, pos + 1);
            return;
        }
        
        chs[pos] = Character.toLowerCase(chs[pos]);
        helperDFS(chs, res, pos + 1);
        
        chs[pos] = Character.toUpperCase(chs[pos]);
        helperDFS(chs, res, pos + 1);
    }
    
	/*
	 * When I saw a problem, my first step is to draw a figure. See the figure
	 * below: abc abc Abc 0 abc aBc Abc ABc 1 abc abC aBc aBC Abc AbC ABc ABC 2
	 * 
	 * There we go! Is that a typical BFS/DFS problem? Yes, you are right! Be
	 * careful to check whether a character is a digit or a letter(lower case or
	 * upper case).
	 */
    
    public List<String> letterCasePermutationBFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        
        return new LinkedList<>(queue);
    }
}
