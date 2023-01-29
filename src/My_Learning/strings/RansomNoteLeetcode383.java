package My_Learning.strings;

public class RansomNoteLeetcode383 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] arr1 = new int[26];

		for (int i = 0; i < ransomNote.length(); i++) {
			arr1[ransomNote.charAt(i) - 'a']++;
		}
		for (int i = 0; i < magazine.length(); i++) {
			arr1[magazine.charAt(i) - 'a']--;
		}

		for (int i : arr1) {
			if (i > 0)
				return false;
		}
		return true;
	}

}
