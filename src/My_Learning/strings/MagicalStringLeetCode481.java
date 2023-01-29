package My_Learning.strings;

public class MagicalStringLeetCode481 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int magicalString(int n) {
		if (n <= 0)
			return 0;
		if (n <= 3)
			return 1;

		int[] a = new int[n + 1];
		a[0] = 1;
		a[1] = 2;
		a[2] = 2;
		int head = 2, tail = 3, num = 1, result = 1;

		while (tail < n) {
			for (int i = 0; i < a[head]; i++) {
				a[tail] = num;
				if (num == 1 && tail < n)
					result++;
				tail++;
			}
			num = num ^ 3;
			head++;
		}

		return result;
	}

}
