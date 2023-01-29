package My_Learning.LeetCodeQuestions;

import java.util.Scanner;

public class JwelesAndStonesLeetCode771 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter jewels :: ");
		String jewels = sc.nextLine();

		System.out.println("Please enter stones :: ");
		String stones = sc.nextLine();

		int stoneAndJewelCount = numJewelsInStones(jewels, stones);

		System.out.println(stoneAndJewelCount);

		sc.close();

	}

	private static int numJewelsInStones(String jewels, String stones) {
		int ans = 0;
		for (int index = 0; index < stones.length(); ++index) {
			// converting the char to char sequence in order
			// to use contains method
			String element = Character.toString(stones.charAt(index));

			if (isJewels(element, jewels)) {
				ans += 1;
			}
		}

		return ans;
	}

	private static boolean isJewels(String element, String jewels) {

		if (jewels.contains(element)) {
			return true;
		}

		return false;
	}

	// regex apprach
	public int numJewelsInStones1(String J, String S) {
		return S.replaceAll("[^" + J + "]", "").length();
	}

	// hashing approach
	public int numJewelsInStones3(String J, String S) {
		int[] cnt = new int[128];
		for (char c : S.toCharArray())
			cnt[c]++;
		int ans = 0;
		for (char c : J.toCharArray())
			ans += cnt[c];
		return ans;
	}

}
