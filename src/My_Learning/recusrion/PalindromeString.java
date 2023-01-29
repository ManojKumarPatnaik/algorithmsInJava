package My_Learning.recusrion;

import java.util.Scanner;

public class PalindromeString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string to be checked as palindrome :: ");
		String s = sc.nextLine();
		
		boolean ans = isPalindrome(s);
		System.out.println(ans);
		
		
		sc.close();
	}

	private static boolean isPalindrome(String s) {
		
		boolean ans = helper(s,0);
		
		
		return ans;
	}

	private static boolean helper(String s, int i) {
		
		int n = s.length();
		
		if(i >= n/2) {
			return true;
		}
		
		// Base chase
		if(s.charAt(i) != s.charAt(n-i-1)) {
			return false;
		}
		
		return helper(s, i+1);

	}
}
