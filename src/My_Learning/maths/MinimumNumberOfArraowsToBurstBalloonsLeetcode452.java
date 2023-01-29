package My_Learning.maths;

import java.util.Arrays;

public class MinimumNumberOfArraowsToBurstBalloonsLeetcode452 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		int[][] points1 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };

		int[][] points2 = { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 }, { 0, 9 }, { 3, 9 }, { 0, 6 },
				{ 2, 8 } };
		System.out.println(findMinArrowShots(points2));
	}

	public static int findMinArrowShots(int[][] points) {

		Arrays.sort(points, (a, b) -> {
			if (a[0] != b[0]) {
				return Integer.compare(a[0], b[0]);
			} else {
				return Integer.compare(a[1], b[1]);
			}
		});

		for (int i = 0; i < points.length; i++) {
			System.out.println(Arrays.toString(points[i]));
		}

		int currentArrow = 1;
		int i = 0; // current balloon index
		int j = 1; // all balloons which can be burst
		while (j < points.length) {
			if (points[i][1] >= points[j][0] && points[i][1] <= points[j][1]) {
				j++;
			} else {
				i = j;
				currentArrow++;
				j++;
			}
		}

		return currentArrow;
	}
	
	public static int findMinArrowShots1(int[][] segments) {
        Arrays.sort(segments, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0, arrow = 0;
        for (int i = 0; i < segments.length; i ++) {
            if (ans == 0 || segments[i][0] > arrow) {
                ans ++;
                arrow = segments[i][1];
            }
        }
        return ans;
    }
}
