package My_Learning.binaryTrees_2;

public class NumberPairSatisfyingInequalityFenWickTreeLeetcode2426 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
		int n = nums1.length;
		int[] nums3 = new int[n];
		for (int i = 0; i < n; i++) {
			nums3[i] = nums1[i] - nums2[i];
		}
		long count = 0;
		int[] arr = new int[100000];
		int offset = 50000;
		Fenwick f = new Fenwick(arr);
		for (int j = 0; j < n; j++) {
			int key = offset + nums3[j] + diff;
			count += f.sum(key);
			f.update(offset + nums3[j], 1);
		}
		return count;
	}

	class Fenwick {
		long[] bit;

		public Fenwick(int arr[]) {
			bit = new long[arr.length + 1]; // index starts from 1 not 0.

			for (int i = 0; i < arr.length; i++) {
				int index = i + 1;
				bit[index] += arr[i];
				int parent = index + (index & -index); // index of parent
				if (parent < bit.length) {
					bit[parent] += bit[index];
				}
			}
		}

		// return sum of arr[0..index].
		public long sum(int index) {
			long totalSum = 0;
			index = index + 1;

			while (index > 0) {
				totalSum += bit[index];
				index -= index & (-index);
			}
			return totalSum;
		}

		public void update(int index, int val) {
			// index in BIT[] starts from 1
			index = index + 1;

			while (index < bit.length) {
				bit[index] += val;
				index += index & (-index);
			}
		}
	}
}
