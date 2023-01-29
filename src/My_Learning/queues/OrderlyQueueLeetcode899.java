package My_Learning.queues;

import java.util.Arrays;

public class OrderlyQueueLeetcode899 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String orderlyQueue(String S, int K) {
		if (K > 1) {
			char S2[] = S.toCharArray();
			Arrays.sort(S2);
			return new String(S2);
		}
		String res = S;
		for (int i = 1; i < S.length(); i++) {
			String tmp = S.substring(i) + S.substring(0, i);
			if (res.compareTo(tmp) > 0)
				res = tmp;
		}
		return res;
	}

}
