package My_Learning.strings;

import java.util.HashSet;

public class SplitStringInMaxUniqueSubstringLeetcode1593 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int ans;

	public int maxUniqueSplit(String s) {
		this.ans = 0;
		find(0, s, new HashSet<String>());
		return ans;
	}

	private void find(int index, String s, HashSet<String> visited){
        if(index == s.length()){
            this.ans = Math.max(this.ans, visited.size());
            return;
        }
        
        for(int i=index; i<s.length(); i++){
            String subStr = s.substring(index, i+1);
            if(visited.contains(subStr)) continue;
            
            visited.add(subStr);
            find(i+1, s, visited);
            visited.remove(subStr);
        }
	}

}
