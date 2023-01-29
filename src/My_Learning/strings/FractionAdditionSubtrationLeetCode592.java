package My_Learning.strings;

import java.util.Scanner;

public class FractionAdditionSubtrationLeetCode592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Input: expression = "-1/2+1/2+1/3"
//			Output: "1/3"
	
//	abc�    Letters
//	123�    Digits
//	\d      Any Digit
//	\D      Any Non-digit character
//	.       Any Character
//	\.      Period
//	[abc]   Only a, b, or c
//	[^abc]  Not a, b, nor c
//	[a-z]   Characters a to z
//	[0-9]   Numbers 0 to 9
//	\w      Any Alphanumeric character
//	\W      Any Non-alphanumeric character
//	{m}     m Repetitions
//	{m,n}   m to n Repetitions
//	*       Zero or more repetitions
//	+       One or more repetitions
//	?       Optional character
//	\s      Any Whitespace
//	\S      Any Non-whitespace character
//	^�$     Starts and ends
//	(�)     Capture Group
//	(a(bc)) Capture Sub-group
//	(.*)    Capture all
//	(ab|cd) Matches ab or cd

	
//	Keep the overall result in A / B, read the next fraction into a / b.
//	Their sum is (Ab + aB) / Bb (but cancel their greatest common divisor).
	
	public String fractionAddition(String expression) {
	    Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])"); // delimiter the string with / or -+
	    
	    
	    int A = 0, B = 1;
	    while (sc.hasNext()) {
	        int a = sc.nextInt(), b = sc.nextInt();
	        A = A * b + a * B;
	        B *= b;
	        int g = gcd(A, B);
	        A /= g;
	        B /= g;
	    }
	    
	    sc.close();
	    
	    return A + "/" + B;
	}

	private int gcd(int a, int b) {
	    return a != 0 ? gcd(b % a, a) : Math.abs(b);
	}
}
