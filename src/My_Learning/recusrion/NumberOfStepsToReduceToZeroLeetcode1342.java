package My_Learning.recusrion;

public class NumberOfStepsToReduceToZeroLeetcode1342 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numberOfSteps(int num) {
		if (num == 0)
			return 0;

		if (num % 2 == 0) {
			return 1 + numberOfSteps(num / 2);
		} else {
			return 1 + numberOfSteps(num - 1);
		}
	}

}
