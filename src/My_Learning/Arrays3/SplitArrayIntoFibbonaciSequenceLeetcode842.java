package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibbonaciSequenceLeetcode842 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to split the array into fibbonaci sequence
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> result = new ArrayList<>();
		splitIntoFibonacciFrom(0, result, S); // start state
		return result;
	}

	private boolean splitIntoFibonacciFrom(int curIdx, List<Integer> result, String S) {
		if (curIdx == S.length() && result.size() >= 3) { // end state (base cases)
			return true;
		}
		for (int i = curIdx; i <= S.length() - 1; i++) {
			if (S.charAt(curIdx) == '0' && i > curIdx) {
				break;
			}
			long num = Long.valueOf(S.substring(curIdx, i + 1));
			if (num > Integer.MAX_VALUE) {
				break;
			}
			if (result.size() <= 1
					|| num == (long) result.get(result.size() - 1) + (long) result.get(result.size() - 2)) {
				result.add((int) num);
				if (splitIntoFibonacciFrom(i + 1, result, S)) {
					return true;
				}
				result.remove(result.size() - 1);
			}
		}
		return false;
	}

}
