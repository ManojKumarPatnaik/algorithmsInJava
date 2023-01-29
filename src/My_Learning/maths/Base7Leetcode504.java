package My_Learning.maths;

public class Base7Leetcode504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String convertToBase7(int num) {
		int base = 1, result = 0;
		while (num != 0) {
			result += base * (num % 7);
			num /= 7;
			base *= 10;
		}
		return String.valueOf(result);
	}

}
