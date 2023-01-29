package My_Learning.LeetCodeQuestions;

public class ReverseVowelsOFStringLeetCode345 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "hello";
		String ans = reverseVowels(s);
		System.out.println(ans);
	}

	public static String reverseVowels(String s) {
		char[] ss = s.toCharArray();
		reverseVowelString(ss);

		return new String(ss);

	}
	
	// method -2
	// Added Leetcode daily solution
	public String reverseVowels2(String s) {
	    if (s == null || s.length() == 0) return s;
	        char[] chars = s.toCharArray();
	        int start = 0;
	        int end = chars.length - 1;
	        
	        while(start < end) {
	            if (!IsVowel(chars[start])) start++;
	            else if (!IsVowel(chars[end])) end--;
	            else {
	                char temp = chars[start];
	                chars[start] = chars[end];
	                chars[end] = temp;
	                start++;
	                end--;
	            }
	        }
	        
	        return new String(chars);
	    }
	    
	    public boolean IsVowel(char c) {
	        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
	            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	    }

	public static void reverseVowelString(char[] s) {
		int i = 0;
		int j = s.length - 1;

		while (i < j) {
			if (isVowel(s[i]) == false) {
				i = getILocation(i, s);
			}

			if (isVowel(s[j]) == false) {
				j = getJLocation(j, s);
			}
			System.out.println("Value of i :: "+i);
			System.out.println("Value of j :: "+j);
			System.out.println("Char at i :: "+s[i]);
			System.out.println("Char at j :: "+s[j]);
			swap(s, i, j);
			
			if(i<j) break;
			
			++i;
			--j;
		}

		return;

	}

	public static int getILocation(int i, char[] s) {
		int n = s.length;

		while (i < n) {
			if (isVowel(s[i]))
				return i;
			else
				++i;
		}
		return -1;
	}

	public static int getJLocation(int j, char[] s) {

		while (j >= 0) {
			if (isVowel(s[j]))
				return j;
			else
				--j;
		}
		return -1;
	}

	public static boolean isVowel(char chr) {
		return (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u') ? true : false;
	}

	public static void swap(char[] s, int i, int j) {
		char t = s[i];
		s[i] = s[j];
		s[j] = t;
	}

}
