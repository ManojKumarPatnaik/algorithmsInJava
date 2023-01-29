package My_Learning.Arrays3;

public class SmallestRotationWithHighestScoreLeetcode798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int bestRotation(int[] A) {
		int N = A.length;
		int change[] = new int[N];
		for (int i = 0; i < N; ++i)
			change[(i - A[i] + 1 + N) % N] -= 1;
		int max_i = 0;
		for (int i = 1; i < N; ++i) {
			change[i] += change[i - 1] + 1;
			max_i = change[i] > change[max_i] ? i : max_i;
		}
		return max_i;
	}

}
