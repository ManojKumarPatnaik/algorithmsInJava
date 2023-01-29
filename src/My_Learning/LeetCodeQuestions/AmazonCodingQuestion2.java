package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class AmazonCodingQuestion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arr = new ArrayList<>();
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);

		// [4,5,6,7]
		// [9,11,13] -> [9,1,3]
		// [10,4] -> [0,4]

		System.out.println(getEncryptedNumber(arr));
	}

	private static String getEncryptedNumber1(List<Integer> numbers) {
		String ans = "";

		if (numbers == null || numbers.isEmpty())
			return ans;

		if (numbers.size() == 1) {
			int num = numbers.get(0);
			if (getSize(num) > 1) {
				int lastDigit = getLastDigit(num);

				ans = "" + lastDigit + "";
			}
		}

		if (numbers.size() == 2) {
			ans = getNewNumber(numbers);
		}
		int len = numbers.size() - 1;

		for (int j = 0; j < len; j++) {

			List<Integer> tempArr = new ArrayList<>();

			for (int i = 0; i < numbers.size(); i++) {
				int n1 = numbers.get(i);
				int n2 = numbers.get(i + 1);

				System.out.println(n1 + " " + n2);

				int newNum = n1 + n2;
				int newNumLastDigit = newNum;

				if (getSize(newNum) > 1) {
					newNumLastDigit = getLastDigit(newNum);
				}

				tempArr.add(newNumLastDigit);

				if (tempArr.size() > 2)
					continue;

				if (tempArr.size() == 2) {
					ans = getNewNumber(numbers);
					break;
				}

			}
			System.out.println(tempArr.toString());
			numbers = tempArr;
		}

		return ans;
	}

	public static String getEncryptedNumber(List<Integer> numbers) {
		int N = numbers.size();

		// If the value of N is 2
		if (N == 2) {
			if (numbers.get(0) == 0 && numbers.get(1) == 0)
				return "00";
			else if (numbers.get(0) == 0)
				return "0" + Integer.toString(numbers.get(1));
			else
				return Integer.toString(numbers.get(0)) + Integer.toString(numbers.get(1));
		}

		for (int i = 0; i < N - 1; i++)
			numbers.set(i, ((numbers.get(i) + numbers.get(i + 1)) % 10));

		numbers.remove(numbers.size() - 1);

		return getEncryptedNumber(numbers);
	}

	public static String getNewNumber(List<Integer> numbers) {
		String ans = "";

		if (numbers.size() >= 2) {
			int n1 = numbers.get(0);
			int n2 = numbers.get(1);
			int lastDigit1 = n1;
			int lastDigit2 = n2;

			if (getSize(n1) > 1) {
				lastDigit1 = getLastDigit(n1);
			}

			if (getSize(n2) > 1) {
				lastDigit2 = getLastDigit(n2);
			}

			ans = "" + lastDigit1 + "" + lastDigit2 + "";
		}

		return ans;
	}

	public static int getLastDigit(int num) {
		return num % 10;
	}

	public static int getSize(Integer num) {
		return num.toString().length();
	}

}
