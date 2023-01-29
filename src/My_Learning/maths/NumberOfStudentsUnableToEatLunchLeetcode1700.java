package My_Learning.maths;

public class NumberOfStudentsUnableToEatLunchLeetcode1700 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countStudents(int[] A, int[] B) {
		int count[] = { 0, 0 }, n = A.length, k;
		for (int a : A)
			count[a]++;
		for (k = 0; k < n && count[B[k]] > 0; ++k)
			count[B[k]]--;
		return n - k;
	}

}
