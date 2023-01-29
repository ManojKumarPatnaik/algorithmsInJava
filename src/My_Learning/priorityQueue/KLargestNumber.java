package My_Learning.priorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inpArr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		int k = 4;
		ArrayList<Integer> arr = getKLargestNum(inpArr, k);
		System.out.println(arr.toString());

	}

	public static ArrayList<Integer> getKLargestNum(int[] inpArr, int k) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> pq = new PriorityQueue<>(k);

		for(int i : inpArr) {
			if(pq.size() <k) {
				pq.add(i);
			} else {
				int mVal = pq.peek();
				if(i > mVal) {
					pq.poll();
					pq.add(i);
				} 
			}
		}
		
//		for(int i=0;i<k;i++)
//        {
//            pq.add(inpArr[i]);
//        }
//        
//        for(int i=k;i<inpArr.length;i++)
//        {
//            int minVal=pq.peek();
//            if(minVal<inpArr[i])
//                minVal=inpArr[i];
//            if(minVal!=pq.peek())
//            {
//                pq.poll();
//                pq.add(minVal);
//            }
//        }
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(!pq.isEmpty())
            arr.add(pq.poll());
        
        return arr;
        
        
	}
	
	public static ArrayList<Integer> kLargest(int inpArr[], int k) {
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
