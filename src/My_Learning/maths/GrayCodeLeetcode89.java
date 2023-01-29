package My_Learning.maths;

import java.util.ArrayList;
import java.util.List;

public class GrayCodeLeetcode89 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> grayCode(int n) {
		ArrayList<String> ans = helper(n);
		ArrayList<Integer> finalAns = new ArrayList<>();
		for (int i = 0; i < ans.size(); i++) {
			String str = ans.get(i);
			finalAns.add(Integer.parseInt(str, 2));
		}
		return finalAns;
	}

	public ArrayList<String> helper(int n) {
		if (n == 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add("0");
			list.add("1");
			return list;
		}
		ArrayList<String> rres = helper(n - 1);
		ArrayList<String> myRes = new ArrayList<>();
		for (int i = 0; i < rres.size(); i++) {
			myRes.add("0" + rres.get(i));
		}
		for (int i = rres.size() - 1; i >= 0; i--) {
			myRes.add("1" + rres.get(i));
		}
		return myRes;
	}

}
