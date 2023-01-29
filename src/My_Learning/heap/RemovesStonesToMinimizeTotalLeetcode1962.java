package My_Learning.heap;

import java.util.PriorityQueue;

public class RemovesStonesToMinimizeTotalLeetcode1962 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] piles = {5,4,9}; 
//		int k = 2;
		
		
		int[] piles = {4,3,6,7}; 
		int k = 3;
		System.out.println(minStoneSum(piles, k));
		
	}
	
	public static int minStoneSum1(int[] piles, int k) {

		if(piles.length <= 0)
			return 0;
		
		int minStones = Integer.MAX_VALUE;
		for(int i = 0; i < piles.length; i++) {
			minStones = Math.min(helper(i, k, piles), minStones);
		}
				
		return minStones;
    }

	private static int helper(int i, int k, int[] piles) {
		
		if(i >= piles.length) {
			return Integer.MAX_VALUE;
		}
		
		if(k == 0) {
			return sum(piles);
		}
		
		int temp = piles[i];
		piles[i] = (int)Math.ceil((double)piles[i]/2);
		int pick = helper(i, k-1, piles);
		
		//not pick
		piles[i] = temp;
		int notPick = helper(i+1, k, piles);
		
		return Math.min(pick, notPick);
		
	}

	private static int sum(int[] piles) {
		int sum = 0;
		for(int i : piles) {
			sum+=i;
		}
		return sum;
	}




//	Use a max heap.
//	Each time pop the max value a,
//	remove a / 2 from the number of stones res
//	and push back the ceil half a - a / 2 to the heap.
//	Repeat this operation k times.
//	
//	Complexity
//	Time O(n + klogn)
//	Space O(n)
	
	public static int minStoneSum(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b - a);
        int res = 0;
        for (int a : A) {
            pq.add(a);
            res += a;
        }
        System.out.println(pq.toString());
        while (k-- > 0) {
            int a = pq.poll();
            pq.add(a - a / 2);
            res -= a / 2;
        }
        return res;
    }


}
