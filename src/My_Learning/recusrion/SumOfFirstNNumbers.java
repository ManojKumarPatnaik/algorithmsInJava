package My_Learning.recusrion;

import java.util.Scanner;

public class SumOfFirstNNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the value of n :: ");
		int n = sc.nextInt();

		int result = sumN(n, 0);
		System.out.println("Sum of natural numbers upto " + n + " is :: " + result);
		int ans = sumNGlobal(n);
		System.out.println("Sum of natural numbers upto " + n + " is :: " + ans);
		sc.close();
	}

	// method 1
	private static int sumN(int n, int sum) {
		// Base condition
		if (n < 1) {
			return sum;
		}

		sum += n;

		return sumN(n - 1, sum);
	}

	// method 2
	private static int sumNGlobal(int n) {
		// Base condition
		if (n == 0) {
			return 0;
		}

		return n + sumNGlobal(n - 1);

	}
}
