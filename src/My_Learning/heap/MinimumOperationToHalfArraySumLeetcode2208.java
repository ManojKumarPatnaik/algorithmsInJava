package My_Learning.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumOperationToHalfArraySumLeetcode2208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	we are greedily picking the maximum number in the heap, dividing it by two adding
//	in currentSum and pushing currentSum in priorityQueue.
//	why greedy ?
//	because we want to increase curentSum >= tar in as minimum operations as possible.
	
	public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        Double sum = 0.0;
        for (int i : nums) {
            pq.add(i * 1.0);
            sum += i;
        }
        double tar = sum / 2;
        int operations = 0;
        
        double currentSum = 0;
        while (currentSum < tar) {
            double pop = pq.remove();
            currentSum += pop / 2;
            pq.add(pop / 2);
            operations++;
        }
        return operations;
    }

}
