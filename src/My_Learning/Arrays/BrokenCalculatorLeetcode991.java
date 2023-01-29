package My_Learning.Arrays;

public class BrokenCalculatorLeetcode991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int brokenCalcRecursive(int startValue, int target) {
		return fun(startValue, target);
	}

	public int fun(int n, int target) {

		if (n >= target)
			return n - target;

		if (target % 2 == 0) {
			return 1 + brokenCalc(n, target / 2);
		}
		return 1 + brokenCalc(n, target + 1);

	}

	// Iterative apparoach
	public int brokenCalc(int startValue, int target) {
		int result = 0;
		while (target > startValue) {
			if (target % 2 == 0) {
				target /= 2;
			} else {
				target++;
			}
			result++;
		}
		return result + (startValue - target);
	}

}
