package My_Learning.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfHalfStrngAlikeLeetcode1704 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(halvesAreAlike("textbook"));
	}

	public static boolean halvesAreAlike(String s) {
        int len = s.length();
        int first = 0, last = len-1, a = 0, b = 0;
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while(first<last){
            if(vowel.contains(s.charAt(first)))
                a++;
            
            if(vowel.contains(s.charAt(last)))
                b++;
            
            first++;
            last--;
        }
        
        return a==b;
    }
}
