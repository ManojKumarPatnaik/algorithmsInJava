package My_Learning.strings;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabelsLeetCode763 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Input: s = "ababcbacadefegdehijhklij" Output: [9,7,8] Explanation: The
	 * partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that
	 * each letter appears in at most one part. A partition like "ababcbacadefegde",
	 * "hijhklij" is incorrect, because it splits s into less parts.
	 */
/*
 * Keep the last occurance of a char which will deneote how much we can include
 * the in the current partition. Make sure also compare the current indx with
 * the max last occurance.
 */
	
	 public List<Integer> partitionLabels(String S) {
	        if(S == null || S.length() == 0){
	            return null;
	        }
	        List<Integer> list = new ArrayList<>();
	        int[] map = new int[26];  // record the last index of the each char

	        for(int i = 0; i < S.length(); i++){
	            map[S.charAt(i)-'a'] = i;
	        }
	        // record the end index of the current sub string
	        int last = 0;
	        int start = 0;
	        for(int i = 0; i < S.length(); i++){
	            last = Math.max(last, map[S.charAt(i)-'a']);
	            if(last == i){
	                list.add(last - start + 1);
	                start = last + 1;
	            }
	        }
	        return list;
	 }
}

