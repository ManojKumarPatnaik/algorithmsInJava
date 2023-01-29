package My_Learning.numberTheory;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixLeeetcode1018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Boolean> prefixesDivBy5(int[] A) {
		List<Boolean> result = new ArrayList<>(A.length);
		int s = 0;
		for (int i : A)
			result.add((s = (s * 2 + i) % 5) == 0);

		return result;
	}

}
