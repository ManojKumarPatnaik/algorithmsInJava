package My_Learning.Arrays3;

import java.util.HashMap;
import java.util.Map;

public class RandomPickWithBlackListLeetcode710 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int size = 0;
	Map<Integer, Integer> valToIndex = new HashMap<>();

	public RandomPickWithBlackListLeetcode710(int n, int[] blacklist) {
        size = n - blacklist.length;
        for (int i : blacklist) {
            valToIndex.put(i, -1);
        }
        int last = n - 1;
        for(int i : blacklist) {
		//pay attention to this
            if (i >= size) {
                continue;
            }
			//pay attention to this
            while(valToIndex.containsKey(last)) {
                last--;
            }
            valToIndex.put(i, last);
            last--;
        }
    }

}
