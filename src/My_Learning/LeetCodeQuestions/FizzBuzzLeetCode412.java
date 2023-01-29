package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzLeetCode412 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ans = fizzBuzz(15);
		System.out.println(ans.toString());
	}
	
	public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        for(int  i = 1; i<= n; i++){
        	if(i%3==0 && i%5==0) ans.add("FizzBuzz");
        	else if(i%3==0 ) ans.add("Fizz");
            else if( i%5==0 ) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }
        
       return ans;
    }

}
