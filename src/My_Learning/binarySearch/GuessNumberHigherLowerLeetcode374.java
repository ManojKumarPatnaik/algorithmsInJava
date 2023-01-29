package My_Learning.binarySearch;

public class GuessNumberHigherLowerLeetcode374 {
	int pickedNum = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	// method to guess number
	public int guessNumber(int n) {
		int l = 1, r = n;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (guess(mid) == 0)
				return mid;
			else if (guess(mid) == 1)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return -1;
	}
	
	public int guess(int n) {
		if (n>pickedNum) return -1;
		else if(n<pickedNum) return 1;
		else return 0;
	}

}
