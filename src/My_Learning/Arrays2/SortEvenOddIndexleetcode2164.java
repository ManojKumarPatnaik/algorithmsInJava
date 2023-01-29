package My_Learning.Arrays2;

import java.util.ArrayList;
import java.util.Collections;

public class SortEvenOddIndexleetcode2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] sortEvenOdd(int[] nums) {
		int size = nums.length;
		ArrayList<Integer> evenIndexValue = new ArrayList<>();
		ArrayList<Integer> oddIndexValue = new ArrayList<>();
		for (int i = 0; i < nums.length; i += 2) {
			evenIndexValue.add(nums[i]);
		}
		for (int i = 1; i < nums.length; i += 2) {
			oddIndexValue.add(nums[i]);
		}
		Collections.sort(evenIndexValue);
		Collections.sort(oddIndexValue);
		int indforarraylist = 0;
		for (int i = 0; i < size; i += 2) {
			nums[i] = evenIndexValue.get(indforarraylist);
			indforarraylist++;
		}
		indforarraylist = oddIndexValue.size() - 1;
		for (int i = 1; i < size; i += 2) {
			nums[i] = oddIndexValue.get(indforarraylist);
			indforarraylist--;
		}
		return nums;
	}

}
