package My_Learning.Arrays3;

public class FindStudentThatWillReplaceChalkLeetcode1894 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int chalkReplacer(int[] chalk, int k) {
		long sum = 0;
		int n = chalk.length;
		for (int i = 0; i < n; i++) {
			sum += chalk[i];
		}
		k %= sum;
		int i;
		for (i = 0; i < n; i++) {
			if (chalk[i] <= k) {
				k -= chalk[i];
			} else {
				break;
			}
		}
		return i;
	}

}
