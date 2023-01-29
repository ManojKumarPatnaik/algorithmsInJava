package My_Learning.maths;

public class FindTheHighestAltitudeLeetcode1732 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestAltitude(int[] gain) {
		int max_alt = 0;
		int curr_alt = 0;
		for (int i = 0; i < gain.length; i++) {
			curr_alt += gain[i];
			max_alt = Math.max(curr_alt, max_alt);
		}
		return max_alt;
	}

}
