package My_Learning.Arrays3;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStreamLeetcode295 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// implemented data stream meadian finder
	PriorityQueue<Integer> smallNums; // Max Heap
	PriorityQueue<Integer> largeNums; // Min Heap

	public FindMedianFromDataStreamLeetcode295() {
		smallNums = new PriorityQueue<>(Collections.reverseOrder());
		largeNums = new PriorityQueue<>();
	}

	public void addNum(int num) {
		// Add to maxHeap first (Group of smaller numbers)
		smallNums.offer(num);
		// Balance the heaps
		largeNums.offer(smallNums.poll());
		if (largeNums.size() > smallNums.size()) {
			smallNums.offer(largeNums.poll());
		}
	}

	public double findMedian() {
		if (smallNums.size() != largeNums.size()) {
			return smallNums.peek();
		}
		return (smallNums.peek() + largeNums.peek()) / 2.0;
	}

}
