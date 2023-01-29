package My_Learning.strings;

import java.util.ArrayList;
import java.util.List;

public class StampingTheSequenceLeetcode936 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] movesToStamp(String stamp, String target) {
		List<Integer> result = new ArrayList<>();
		char[] targetArray = target.toCharArray();
		if (!DFS(targetArray, result, stamp, targetArray.length)) {
			return new int[0];
		}
		int[] arrayResult = new int[result.size()];
		for (int i = 0; i < arrayResult.length; i++) {
			arrayResult[i] = result.get(arrayResult.length - 1 - i);
		}
		return arrayResult;
	}

	private boolean DFS(char[] array, List<Integer> result, String stamp, int left) {
		if (left == 0) {
			return true;
		}
		// char[] tmp = new char[stamp.length()];
		for (int i = 0; i < array.length - stamp.length() + 1; i++) {
			int remove = isEqual(array, i, stamp);
			if (remove > 0) {
				result.add(i);
				for (int j = 0; j < stamp.length(); j++) {
					// tmp[j] = array[i + j];
					array[i + j] = '#';
				}
				if (DFS(array, result, stamp, left - remove)) {
					return true;
				} else {
					return false;
				}
				/*
				 * for (int j = 0; j < stamp.length(); j++) { array[i + j] = tmp[j]; }
				 * result.remove(result.size() - 1);
				 */
			}
		}
		return false;
	}

	private int isEqual(char[] array, int start, String stamp) {
		int remove = 0;
		for (int i = 0; i < stamp.length(); i++) {
			if (array[i + start] == '#') {
				continue;
			}
			if (array[i + start] == stamp.charAt(i)) {
				remove++;
				continue;
			}
			return -1;
		}
		return remove;
	}

}
