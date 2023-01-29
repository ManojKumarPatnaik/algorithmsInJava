package My_Learning.Arrays3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPickWeightLeetcode528 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private final int[] w;

	public RandomPickWeightLeetcode528(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.w = w;
    }

	public int pickIndex() {
		int n = w.length;
		int idx = ThreadLocalRandom.current().nextInt(w[n - 1]) + 1;
		int i = Arrays.binarySearch(w, idx);
		return i >= 0 ? i : ~i;
	}

}
