/**
 * 
 */
package My_Learning.strings;

/**
 * @author ujjwa
 *
 */
public class MergeAlternativelyStringLeetcode1768 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public String mergeAlternately(String word1, String word2) {
			int n = word1.length();
			int m = word2.length();
			StringBuilder sb = new StringBuilder();
			int i = 0, j = 0;

			while (i < n && j < m) {
				sb.append(word1.charAt(i));
				i++;
				sb.append(word2.charAt(j));
				j++;
			}

			while (i < n) {
				sb.append(word1.charAt(i));
				i++;
			}

			while (j < m) {
				sb.append(word2.charAt(j));
				j++;
			}

			return sb.toString();
		}

		// Using one loop
		public String mergeAlternatelyOneLoop(String w1, String w2) {
			int n = w1.length(), m = w2.length(), i = 0, j = 0;
			StringBuilder res = new StringBuilder();
			while (i < n || j < m) {
				if (i < w1.length())
					res.append(w1.charAt(i++));
				if (j < w2.length())
					res.append(w2.charAt(j++));
			}
			return res.toString();
		}

		// using one pointer
		public String mergeAlternatelyOnePointera(String w1, String w2) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < w1.length() || i < w2.length(); ++i) {
				if (i < w1.length())
					res.append(w1.charAt(i));
				if (i < w2.length())
					res.append(w2.charAt(i));
			}
			return res.toString();
		}

	}
}
