package My_Learning.Arrays2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleThreeLeetcode630 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Solution for scheduling courses
	public int scheduleCourse(int[][] courses) {

		Arrays.sort(courses, (course1, course2) -> course1[1] - course2[1]);

		int days = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

		for (int[] course : courses) {
			if (days + course[0] <= course[1]) {
				days += course[0];
				maxHeap.offer(course[0]);
			} else if (!maxHeap.isEmpty() && maxHeap.peek() > course[0]) {
				days -= maxHeap.poll();
				days += course[0];
				maxHeap.offer(course[0]);
			}
		}

		return maxHeap.size();
	}
}
