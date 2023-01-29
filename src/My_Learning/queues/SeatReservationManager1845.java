package My_Learning.queues;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatReservationManager1845 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private final Queue<Integer> seats;
	private int smallest;

	public SeatReservationManager1845(int n) {
		seats = new PriorityQueue<>();
		smallest = 0;
	}

	public int reserve() {
		return seats.isEmpty() ? ++smallest : seats.poll();
	}

	public void unreserve(int seatNumber) {
		seats.offer(seatNumber);
	}

}
