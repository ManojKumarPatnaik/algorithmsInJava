package My_Learning.strings;

public class FindUniqueCharInStringLeetcode387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int len = s.length();
		if (len == 1)
			return 0;
		char[] cc = s.toCharArray();
		int slow = 0, fast = 1;
		int[] count = new int[256];
		count[cc[slow]]++;
		while (fast < len) {
			count[cc[fast]]++;
			// if slow pointer is not a unique character anymore, move to the next unique
			// one
			while (slow < len && count[cc[slow]] > 1)
				slow++;
			if (slow >= len)
				return -1; // no unique character exist
			if (count[cc[slow]] == 0) { // not yet visited by the fast pointer
				count[cc[slow]]++;
				fast = slow; // reset the fast pointer
			}
			fast++;
		}
		return slow;
	}

}
