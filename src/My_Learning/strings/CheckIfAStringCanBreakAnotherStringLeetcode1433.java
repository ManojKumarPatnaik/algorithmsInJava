package My_Learning.strings;

public class CheckIfAStringCanBreakAnotherStringLeetcode1433 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkIfCanBreak(String s1, String s2) {
		int n = s1.length();
		int[] arr = new int[26], brr = new int[26];
		for (int i = 0; i < n; i++)
			arr[s1.charAt(i) - 97]++;
		for (int i = 0; i < n; i++)
			brr[s2.charAt(i) - 97]++;
		int count1 = 0, count2 = 0;
		boolean f1 = false, f2 = false;
		for (int i = 0; i < 26; i++) {
			count1 += arr[i];
			count2 += brr[i];
			if (count1 > count2) {
				if (f2)
					return false;
				f1 = true;
			} else if (count2 > count1) {
				if (f1)
					return false;
				f2 = true;
			}
		}
		return true;
	}

}
