package My_Learning.Arrays3;

import java.util.Arrays;

public class BagOfTokensLeetcode948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int bagOfTokensScore(int[] A, int P) {
        Arrays.sort(A);
        int res = 0, points = 0, i = 0, j = A.length - 1;
        while (i <= j) {
            if (P >= A[i]) {
                P -= A[i++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                points--;
                P += A[j--];
            } else {
                break;
            }
        }
        return res;
    }

}
