package My_Learning.heap;

import java.util.PriorityQueue;

public class KthLargestInStreamLeetcode703 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	PriorityQueue<Integer> minHeap;
    int k;
    
    // added implementation method for Kth Largest data in stream
    public KthLargestInStreamLeetcode703(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<Integer>((a, b) -> (a - b));
        
        /*
        * Intitution
          here we are using the min heap, which maintain 
          minimum value in root.
        */
        
        
        for(int num : nums){
            //store the all the number in minHeap
            minHeap.add(num);
            
            //remove lowest number, 
            if(minHeap.size() > k) minHeap.remove();     
        }
    }
    
    public int add(int val) {
        //store number in minHeap
        minHeap.add(val);
        
        //remove lowest number, 
        if(minHeap.size() > k) minHeap.remove();
        
        
        return minHeap.peek();
    }

}
