package My_Learning.strings;

import java.util.*;

public class AlphabetBoardPathLeetcode1138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(alphabetBoardPath("leet"));
	}

	public String alphabetBoardPath1(String target) {
		int x = 0, y = 0;
		StringBuilder sb = new StringBuilder();
		for (char ch : target.toCharArray()) {
			int x1 = (ch - 'a') % 5, y1 = (ch - 'a') / 5;
			sb.append(String.join("", Collections.nCopies(Math.max(0, y - y1), "U"))
					+ String.join("", Collections.nCopies(Math.max(0, x1 - x), "R"))
					+ String.join("", Collections.nCopies(Math.max(0, x - x1), "L"))
					+ String.join("", Collections.nCopies(Math.max(0, y1 - y), "D")) + "!");
			x = x1;
			y = y1;
		}
		return sb.toString();
	}

	public static String alphabetBoardPath(String target) {
		String ans = "";

		Map<Character, List<Integer>> charPosMap = new HashMap<>();
		int i = 0, j = 0;
		for (int k = 0; k < 26; k++) {
			int ch = 'a' + k;
			List<Integer> posList = new ArrayList<>(2);
			if (j < 5) {
				posList.add(i);
				posList.add(j);
			} else {
				i = i + 1;
				j = 0;
				posList.add(i);
				posList.add(j);
			}
			j++;
			charPosMap.put((char) ch, posList);
		}

		// pos[0] pos[1] -> currPosI = 0, currPosJ = 0
		int currPosI = 0, currPosJ = 0;
		for (char ch : target.toCharArray()) {
			List<Integer> pos = charPosMap.get(ch);
			System.out.println(ch + ": " + pos.toString() + ", ans : " + ans);
			// move down
			if (currPosI <= pos.get(0)) {
				ans += addChar(ans, 'D', pos.get(0) - currPosI);
			} else {
				ans += addChar(ans, 'U', currPosI - pos.get(0));
			}

			if (currPosJ <= pos.get(1)) {
				ans += addChar(ans, 'R', pos.get(1) - currPosJ);
			} else {
				ans += addChar(ans, 'L', currPosJ - pos.get(1));

			}
			System.out.println("ans : " + ans);
			currPosI = pos.get(0);
			currPosJ = pos.get(1);
			System.out.println("currPosI : " + currPosI + ", currPosJ : " + currPosJ);
			ans += '!';
			System.out.println("ans : " + ans);

		}

		// System.out.println(charPosMap.entrySet());
		return ans;
	}

	private static String addChar(String ans, char c, int i) {
		String s = new String();

		while (i > 0) {
			s += c;
			i--;
		}

		return s;

	}

}
