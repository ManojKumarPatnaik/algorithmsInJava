package My_Learning.binarySearch;

public class MinCostToMoveChipsLeetcode1217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCostToMoveChips(int[] chips) {
		int even = 0;
		for (int i : chips)
			if (i % 2 == 0)
				even++;
		return Math.min(even, chips.length - even);
	}

}
