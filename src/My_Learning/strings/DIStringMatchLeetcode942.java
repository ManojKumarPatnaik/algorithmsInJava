package My_Learning.strings;

public class DIStringMatchLeetcode942 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] diStringMatch(String s) {
		int[] res = new int[s.length() + 1];
		int nbrI = 0, nbrD = res.length - 1;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (currChar == 'I') {
				res[i] = nbrI;
				nbrI++;
			} else {
				res[i] = nbrD;
				nbrD--;
			}
		}

		res[res.length - 1] = nbrD;

		return res;
	}

}
