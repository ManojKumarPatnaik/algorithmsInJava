package My_Learning.stack;

public class NextGreaterELementThreeLeetcode556 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int nextGreaterElement(int n) {

		int index1 = -1;
		char[] ch = String.valueOf(n).toCharArray();
		int len = ch.length;
		int i = len - 1;
		while (i > 0) {
			if (ch[i] > ch[i - 1]) {
				index1 = i - 1;
				break;
			}
			i--;
		}
		if (index1 == -1)
			return -1;
		int index2 = -1;
		i = len - 1;
		while (i > index1) {
			if (ch[i] > ch[index1]) {
				index2 = i;
				break;
			}
			i--;
		}
		char temp = ch[index1];
		ch[index1] = ch[index2];
		ch[index2] = temp;

		StringBuilder result = new StringBuilder();
		for (i = 0; i <= index1; i++) {
			result.append(ch[i]);
		}
		for (i = len - 1; i > index1; i--) {
			result.append(ch[i]);
		}

		// Long conversion due to failure of a test case (read note in question)
		return Long.parseLong(result.toString()) > Integer.MAX_VALUE ? -1 : Integer.parseInt(result.toString());
	}

}
