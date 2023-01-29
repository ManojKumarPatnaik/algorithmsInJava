package My_Learning.Arrays;

public class SignOfProductArrayLeetcode1822 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arraySign(int[] nums) {
		int negativeCount = 0;
		for (int i : nums) {
			if (signFunc(i) == -1) {
				negativeCount++;
			} else if (i == 0)
				return 0;
		}

		if (negativeCount % 2 == 0)
			return 1;
		else
			return -1;
	}

	public int signFunc(int i) {
		if (i < 0)
			return -1;
		else if (i > 0)
			return 1;
		else
			return 0;
	}

}
