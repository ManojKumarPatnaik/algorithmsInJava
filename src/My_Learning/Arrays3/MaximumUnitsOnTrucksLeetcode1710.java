package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumUnitsOnTrucksLeetcode1710 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumUnits(int[][] boxTypes, int truckSize) {
		// Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // b[1] - a[1] may cause int
		// overflow, credit to @Zudas.
		Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
		int boxes = 0;
		for (int[] box : boxTypes) {
			if (truckSize >= box[0]) {
				boxes += box[0] * box[1];
				truckSize -= box[0];
			} else {
				boxes += truckSize * box[1];
				return boxes;
			}
		}
		return boxes;
	}

}
