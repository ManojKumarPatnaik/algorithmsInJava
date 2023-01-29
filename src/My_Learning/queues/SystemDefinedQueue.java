package My_Learning.queues;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SystemDefinedQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// implementation 1 here processing is done using FIFO but data structure used
		// is Linked list to implements

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(1);
		q.add(2);
		q.add(3);

		System.out.println("Queue Interface using Linked List concrete impl class :: " + q.toString());

		// implementation 2 here processing is done using some priority
		Queue<String> pq = new PriorityQueue<String>();

		pq.add("Ujjwal");
		pq.add("Ram");
		pq.add("Siya");
		pq.add("Ram");

		System.out.println("Queue nterface using Priority Queue concrete impl class ::  " + pq.toString());

		// implementation - 3 using ArrayDequeue<>();
		// implementation - 4 using PriorityBlockingQueue<>();
		
		//
		 // 1. Initialize a queue.
        Queue<Integer> mq = new LinkedList<>();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + mq.peek());
        // 3. Push new element.
        mq.offer(5);
        mq.offer(13);
        mq.offer(8);
        mq.offer(6);
        // 4. Pop an element.
        mq.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + mq.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + mq.size());
	}

}
