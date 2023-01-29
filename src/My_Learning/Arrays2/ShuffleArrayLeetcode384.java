package My_Learning.Arrays2;

import java.util.Random;

public class ShuffleArrayLeetcode384 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int[] nums;
	private int[] shuffleArr;
	private Random rand;

	public ShuffleArrayLeetcode384(int[] nums) {
        this.nums = nums;
        this.shuffleArr = nums.clone();
        this.rand = new Random();
    }

	public int[] reset() {
		// return the nums array
		return nums;
	}

	public int[] shuffle() {
		for (int i = 0; i < shuffleArr.length; i++) {
			// Find a random Index and swap it with element at index i.
			int randIdx = i + rand.nextInt(shuffleArr.length - i);
			swap(i, randIdx);
		}

		return shuffleArr;
	}

	// swap function
	private void swap(int i, int j) {
		int temp = shuffleArr[i];
		shuffleArr[i] = shuffleArr[j];
		shuffleArr[j] = temp;
	}

}
