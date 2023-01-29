package My_Learning.CombinationAndPermutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeterCasePermutationLeetcode784 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> letterCasePermutation(String S) {
		List<String> list = new ArrayList<String>();
		helper(S.toCharArray(), list, 0);
		return list;
	}

	private void helper(char[] c, List<String> list, int i) {
		if (i == c.length)
			list.add(new String(c));
		else if (Character.isLetter(c[i])) {
			c[i] = Character.toLowerCase(c[i]);
			helper(c, list, i + 1);
			c[i] = Character.toUpperCase(c[i]);
			helper(c, list, i + 1);
		} else
			helper(c, list, i + 1);
	}

	public List<String> letterCasePermutation1(String S) {
		if (S == null) {
			return new LinkedList<>();
		}

		List<String> res = new LinkedList<>();
		helperDFS(S.toCharArray(), res, 0);
		return res;
	}

	public void helperDFS(char[] chs, List<String> res, int pos) {
		if (pos == chs.length) {
			res.add(new String(chs));
			return;
		}
		if (chs[pos] >= '0' && chs[pos] <= '9') {
			helperDFS(chs, res, pos + 1);
			return;
		}

		chs[pos] = Character.toLowerCase(chs[pos]);
		helperDFS(chs, res, pos + 1);

		chs[pos] = Character.toUpperCase(chs[pos]);
		helperDFS(chs, res, pos + 1);
	}

}
