package My_Learning.Arrays;

import java.util.LinkedList;
import java.util.List;

public class AddArrayToFormIntegerLeetCode989 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,9,0};
		int k = 181;
		List<Integer> ans = addToArrayForm(arr, k);
		System.out.println(ans.toString());
	}

	public static List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> res = new LinkedList<>();
		
        for (int i = A.length - 1; i >= 0; --i) {
        	
            res.add(0, (A[i] + K) % 10);
            
            K = (A[i] + K) / 10;
        }
        
        // for checking the last position if carry is not equal to zero
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        
        return res;
	}
	
	public static List<Integer> addToArrayForm2(int[] A, int K) {
		LinkedList<Integer> ans = new LinkedList<>();
	    for (int i = A.length - 1; K > 0 || i >= 0; --i, K /= 10) { // loop through A and K, from right to left.
	        K += i >= 0 ? A[i] : 0; // Use K as carry over, and add A[i].
	        ans.offerFirst(K % 10); // add the least significant digit of K.
	    }
	    return ans;
	}
}
