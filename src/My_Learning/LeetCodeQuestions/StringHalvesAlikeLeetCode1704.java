package My_Learning.LeetCodeQuestions;

import java.util.HashSet;
import java.util.Set;

public class StringHalvesAlikeLeetCode1704 {
	
	public static void main(String[] args) {
		String s = "AngelO"; //given even length string
		
		
		
		boolean ans = halvesAreAlike(s);
		System.out.println(ans);
		

	}

	private static boolean halvesAreAlike(String s) {
		// TODO Auto-generated method stub
		
		// making two string a and b of half size
		String a = s.substring(0, s.length()/2);
		String b = s.substring(s.length()/2, s.length());
		
		System.out.println(a+" "+b);
		
		int vowelCountA = getVowelCount(a);
		int vowelCountB = getVowelCount(b);
		
		
		
		return vowelCountA==vowelCountB ;
	}

	private static int getVowelCount(String s) {
		// getting vowel count by ignoring cases AEIOU aeiou
		int count = 0;
		for(char ch : s.toCharArray()) {
			String vowels = "aeiouAEIOU";
			
			if(vowels.contains(Character.toString(ch))) {
				count +=1;
			}
		}
		return count;
	}
	
	 String vowels = "aeiouAEIOU";
	    
    public boolean halvesAreAlike2(String S) {
        int mid = S.length() / 2, ans = 0;
        for (int i = 0, j = mid; i < mid; i++, j++) {
            if (vowels.indexOf(S.charAt(i)) >= 0) ans++;
            if (vowels.indexOf(S.charAt(j)) >= 0) ans--;
        }
        return ans == 0;
    }
    
    public boolean halvesAreAlike3(String s) {
        //add vowels to the set
		Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
		//find the mid
        int mid = s.length() / 2;
        int count = 0;
        //increment the count for left half, decrement count for the second half if its a vowel
		for (int i = 0; i < s.length(); i++)
            count += (set.contains(s.charAt(i))) ? ((i < mid) ? 1 : -1) : 0; 
        //finally count should be 0 to match left and right half
		return count == 0;
    }
}
