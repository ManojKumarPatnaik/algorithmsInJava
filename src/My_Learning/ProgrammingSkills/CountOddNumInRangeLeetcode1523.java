package My_Learning.ProgrammingSkills;

public class CountOddNumInRangeLeetcode1523 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//  My idea here is to make both the numbers odd as it would make the problem much easier.
	
	//We increase the low by 1 and decrease the high by 1 if they are not odd. If the nums are odd already, we do not change them.
	//Simply return the answer as (high - low)/2 + 1;. As, now we count the low and high inclusive.
	
	//For instance, low = 4, high = 8 is same as low = 5 and high = 7 as the odds are only [5,7].
	public int countOdds(int low, int high) {
		if (low % 2 == 0)
			low += 1;
		if (high % 2 == 0)
			high -= 1;
		return (high - low) / 2 + 1;
	}

}
