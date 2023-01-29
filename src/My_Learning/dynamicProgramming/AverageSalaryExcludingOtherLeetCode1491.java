package My_Learning.dynamicProgramming;

public class AverageSalaryExcludingOtherLeetCode1491 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double average(int[] salary) {
		// Arrays.sort(salary);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		double sum = 0;

		for (int i = 0; i < salary.length; i++) {
			min = Math.min(min, salary[i]);
			max = Math.max(max, salary[i]);

			sum += salary[i];
		}

		sum = (sum - min - max) / (salary.length - 2);

		return sum;
	}

}
