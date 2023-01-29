package My_Learning.numberTheory;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberLeetCode202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isHappy(2));

	}
//	Write an algorithm to determine if a number n is happy.
//
//	A happy number is a number defined by the following process:
//
//	Starting with any positive integer, replace the number by the sum of the squares of its digits.
//	Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//	Those numbers for which this process ends in 1 are happy.
//	Return true if n is a happy number, and false if not.
	
//	Input: n = 19
//			Output: true
//			Explanation:
//			12 + 92 = 82
//			82 + 22 = 68
//			62 + 82 = 100
//			12 + 02 + 02 = 1

	public static boolean isHappy(int n) {

		Set<Integer> set = new HashSet<>();

		while (n != 1) {
			int tmp = n;
			int sum = 0;

			while (tmp > 0) {
				int digit = tmp % 10;
				sum += digit * digit;
				tmp /= 10;
			}

			n = sum;

			if (set.contains(n))
				return false;
			else
				set.add(n);
		}

		return true;
	}
	


}
