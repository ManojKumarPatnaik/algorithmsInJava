package My_Learning.numberTheory;

public class ReduceTOBinaryLeetcode1404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSteps(String s) {
		char[] c = s.toCharArray();
		int cl = c.length;
		int ops = 0;
		for (int i = cl - 1; i >= 0; i--) {
			if (i == 0 && c[0] == '1')
				break;
			if (c[i] == '1') {
				i--;
				ops++;
				while (i >= 0 && c[i] != '0') {
					c[i] = '0';
					i--;
					ops++;
				}
				if (i >= 0) {
					c[i] = '1';
					i++;
				}
			}
			ops++;
		}
		return ops;
	}

}
