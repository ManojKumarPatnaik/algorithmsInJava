package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomPickedIndexLeetcode398 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	HashMap<Integer, List<Integer>> m;
	Random r;

	public RandomPickedIndexLeetcode398(int[] nums) {
        m = new HashMap<>(); // --> (1)
        r = new Random();
        int n = nums.length;
        for(int i=0;i<n;i++){
            List<Integer> l = m.getOrDefault(nums[i],new ArrayList<>());
            l.add(i);
            m.put(nums[i],l); // --> (2)
        }
    }

	public int pick(int target) {
		List<Integer> l = m.get(target); // --> (3)
		int n = l.size();
		int in = r.nextInt(n); // -->(4)
		return l.get(in);
	}

}
