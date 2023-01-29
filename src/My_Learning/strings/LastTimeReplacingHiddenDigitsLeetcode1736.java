package My_Learning.strings;

public class LastTimeReplacingHiddenDigitsLeetcode1736 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String maximumTime(String time) {
		char[] a = time.toCharArray();
		for (int i = 0; i < 5; ++i) {
			if (a[i] == '?') {
				if (i == 0) {
					a[i] = a[1] <= '3' || a[1] == '?' ? '2' : '1';
				} else if (i == 1) {
					a[i] = a[0] == '2' ? '3' : '9';
				} else if (i == 3) {
					a[i] = '5';
				} else if (i == 4) {
					a[i] = '9';
				}
			}
		}
		return String.valueOf(a);
	}

}
