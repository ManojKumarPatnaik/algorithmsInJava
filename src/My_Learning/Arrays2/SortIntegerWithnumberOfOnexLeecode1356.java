package My_Learning.Arrays2;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegerWithnumberOfOnexLeecode1356 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] sortByBits(int[] arr) {
		Integer[] a = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
			a[i] = arr[i];
		Arrays.sort(a, Comparator.comparing(i -> Integer.bitCount(i) * 10000 + i));
		for (int i = 0; i < arr.length; i++)
			arr[i] = a[i];
		return arr;
	}

	public int[] sortByBits2(int[] arr) {
		QuickBit(arr, 0, arr.length - 1);
		int j = 1;
		for (int i = 0; i < arr.length && j < arr.length; i++) {
			int iBit = cntBit(arr[i]);
			while (j < arr.length && iBit == cntBit(arr[j])) {
				j++;
			}

			if (j - 1 < arr.length) {
				Quick(arr, i, j - 1);
				i = j - 1;
			}
		}
		return arr;
	}

	public void QuickBit(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int i = start;
		int j = end;
		int pivotBit = cntBit(arr[end]);

		while (i <= j) {
			while (i <= j && cntBit(arr[i]) < pivotBit)
				i++;
			while (i <= j && cntBit(arr[j]) > pivotBit)
				j--;

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		QuickBit(arr, start, j);
		QuickBit(arr, i, end);
	}

	public void Quick(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int i = start;
		int j = end;
		int pivot = arr[end];

		while (i <= j) {
			while (i <= j && arr[i] < pivot)
				i++;
			while (i <= j && arr[j] > pivot)
				j--;

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		Quick(arr, start, j);
		Quick(arr, i, end);
	}

	public int cntBit(int a) {
		int cnt = 0;
		while (a != 0) {
			a = a & (a - 1);
			cnt++;
		}
		return cnt;
	}

}
