package My_Learning.priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 13;
		int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
		int k = 4;

		List<Integer> ans = getKSmallestNum(arr,k);
		
		System.out.println(ans.toString());

	}
	
	public static ArrayList<Integer> getKSmallestNum(int[] inpArr, int k) {
		// TODO Auto-generated method stub

		

		/*
		 * In Java 8+ you can create a max priority queue via one of these methods:
		 * 
		 * Method 1:
		 * 
		 * PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
		 * 
		 * Method 2:
		 * 
		 * PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a); 
		 * 
		 * Method 3:
		 * 
		 * PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b.compareTo(a))
		 */
		PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a,b) -> b.compareTo(a));

		for(int i : inpArr) {
			if(pq.size() <k) {
				pq.add(i);
			} else {
				int mVal = pq.peek();
				if(i < mVal) {
					pq.poll();
					pq.add(i);
				} 
			}
		}
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(!pq.isEmpty())
            arr.add(pq.poll());
        
        return arr;
        
        
	}
	
	public static ArrayList<Integer> kSmallest(int inpArr[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read inpArr, it is passed as function argument.
		* Return output and don't print it.
		* Taking inpArr and printing output is handled automatically.
		*/
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++)
        {
            pq.add(inpArr[i]);
        }
        
        for(int i=k;i<inpArr.length;i++)
        {
            int minVal=pq.peek();
            if(minVal<inpArr[i])
                minVal=inpArr[i];
            if(minVal!=pq.peek())
            {
                pq.poll();
                pq.add(minVal);
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(!pq.isEmpty())
            arr.add(pq.poll());
        return arr;
		
	}

}
