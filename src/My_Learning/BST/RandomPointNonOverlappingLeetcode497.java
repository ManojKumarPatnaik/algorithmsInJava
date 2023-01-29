package My_Learning.BST;

import java.util.Random;

public class RandomPointNonOverlappingLeetcode497 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1. pick a rect
	// 2. pick a point inside this rect
	int[][] rects;
	int[] prefixWeights;
	Random rd;

	public RandomPointNonOverlappingLeetcode497(int[][] rects) {
        this.rects = rects;
        this.prefixWeights = new int[rects.length];
        this.rd = new Random();
        
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int width = rect[2] - rect[0] + 1;
            int height = rect[3] - rect[1] + 1;
            prefixWeights[i] = (i == 0 ? 0 : prefixWeights[i - 1]) + width * height;
        }
    }

	public int[] pick() {
		int rdWeight = rd.nextInt(prefixWeights[prefixWeights.length - 1]);
		int rectIdx = findFirstGreater(rdWeight);
		int[] rect = rects[rectIdx];

		int width = rect[2] - rect[0] + 1;
		int height = rect[3] - rect[1] + 1;
		int total = width * height;
		int rdPoint = rd.nextInt(total);
		return new int[] { rect[0] + rdPoint % width, rect[1] + rdPoint / width };
	}

	private int findFirstGreater(int target) {
		int l = 0, r = prefixWeights.length - 1;
		while (l < r - 1) {
			int mid = l + (r - l) / 2;
			if (prefixWeights[mid] <= target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return prefixWeights[l] > target ? l : r;
	}

}
