package My_Learning.numberTheory;

public class AddDigitsLeetCode258 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(0));
	}

	public static int addDigits(int num) {

		if (num <= 9)
			return num;

		int tmp = num;

		while (tmp > 9) {
			int sum = 0;

			while (tmp > 0) {
				int digit = tmp % 10;
				sum += digit;
				tmp /= 10;
			}

			tmp = sum;
		}

		return tmp;

	}

}
