package My_Learning.LeetCodeQuestions;

public class ReverseStringLeetCode344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[]	s = {'h','e','l','l','o'};
		reverseString2(s);
		System.out.println(new String(s));
	}

	public static void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;

		while (i < j) {

			swap(s, i, j);
			i++;
			j--;
		}

		return;

	}

	public static void swap(char[] s, int i, int j) {
		char t = s[i];
		s[i] = s[j];
		s[j] = t;
	}
	
    public static void reverseString2(char[] s){
        
        int i = 0;
        int j = s.length -1;
        
        char[] ans = helper(s, i, j);
        System.out.println(ans);

    }
    
    public static char[] helper(char[] s, int i, int  j){
        if(i>=j) return s;
        
        int n = s.length;
        if(i<n && j<n){
            swap(s,i,j);
            i++;
            j--;
            
            return helper(s,i,j);
        }
        return s;
    }

}
