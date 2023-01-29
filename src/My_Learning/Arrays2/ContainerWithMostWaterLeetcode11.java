package My_Learning.Arrays2;

public class ContainerWithMostWaterLeetcode11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] heights) {
		int maxArea = 0;

		int left = 0;
		int right = heights.length - 1;

		int maxHeight = 0;

		while (left < right) {
			// because the length is always decreasing
			// we only need to consider a pair if its height
			// is greater than any pair's height we've used so far
			if (heights[left] > maxHeight && heights[right] > maxHeight) {
				maxHeight = Math.min(heights[left], heights[right]);
				maxArea = Math.max(maxArea, maxHeight * (right - left));
			}

			// move pointers
			if (heights[left] == heights[right]) {
				left++;
				right--;
			} else if (heights[left] < heights[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

}
