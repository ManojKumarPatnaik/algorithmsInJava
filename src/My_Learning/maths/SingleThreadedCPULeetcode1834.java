package My_Learning.maths;

import java.util.*;
import java.util.stream.Collectors;

public class SingleThreadedCPULeetcode1834 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
		// Output: [0,2,3,1]

		int[][] tasks = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] task1 = { { 7, 10 }, { 7, 12 }, { 7, 5 }, { 7, 4 }, { 7, 2 } };
		System.out.println(Arrays.toString(getOrder(tasks)));

	}

	public static int[] getOrder(int[][] tasks) {

		List<List<Integer>> newTask = new ArrayList<>();

		for (int[] i : tasks) {
			newTask.add(Arrays.stream(i).boxed().collect(Collectors.toList()));
		}

		for (int i = 0; i < newTask.size(); i++) {
			newTask.get(i).add(i);
		}

		System.out.println("Before sorting :: " + newTask.toString());
		Collections.sort(newTask, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// Sort the lists using the using 0 th index i.e enqueue time
				if (o1.get(0) != o2.get(0)) {
					return o1.get(0).compareTo(o2.get(0));
				} else {
					// Sort the lists using the using 1st index i.e processing time if first index
					// is same
					return o1.get(1).compareTo(o2.get(1));
				}
			}
		});

		int[] output = new int[newTask.size()];
		for (int i = 0; i < newTask.size(); i++) {
			output[i] = newTask.get(i).get(2);
		}

		int t = 0;
		for (int i = 0; i < newTask.size(); i++) {
			List<List<Integer>> availabletask = getAvailbleTask(newTask, t);

			if (!availabletask.isEmpty()) {
				for (List<Integer> avatask : availabletask) {
					output[i] = avatask.get(2);
					t += avatask.get(1);
				}
			} else {
				t += 1;
			}
		}

		System.out.println("After sorting :: " + newTask.toString());
		return output;
	}

	private static List<List<Integer>> getAvailbleTask(List<List<Integer>> newTask, int t) {
		List<List<Integer>> avaiableTask = new ArrayList<>();
		for (List<Integer> i : newTask) {
			if (i.get(0) < t) {
				avaiableTask.add(i);
			}
		}
		return avaiableTask;

	}

	public int[] getOrder1(int[][] tasks) {
		int n = tasks.length;
		int[] ans = new int[n];
		int[][] extTasks = new int[n][3];
		for (int i = 0; i < n; i++) {
			extTasks[i][0] = i;
			extTasks[i][1] = tasks[i][0];
			extTasks[i][2] = tasks[i][1];
		}
		Arrays.sort(extTasks, (a, b) -> a[1] - b[1]); // sorting based on enqueue time
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
		int time = 0;
		int ai = 0;
		int ti = 0;
		while (ai < n) {
			while (ti < n && extTasks[ti][1] <= time) {
				pq.offer(extTasks[ti++]);

			}
			if (pq.isEmpty()) {
				time = extTasks[ti][1];
				continue;
			}
			int[] bestFit = pq.poll();
			ans[ai++] = bestFit[0];
			time += bestFit[2];
		}
		return ans;
	}

}
