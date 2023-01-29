package My_Learning.Arrays3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKSumInArrayLeetcode2386 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long kSum(int[] nums, int k) {
        //1. the max value will be the sum of all the positives
        //2. sums of every subsequence can be derived by removing positives from or adding negetives to the max value
        //3. we can turn every negetive into its absolute value, 
        //   so "max - abs(neg)" means we add negetives to the max-value subsequence.
        //  "max - pos" means we remove positives from the max-value subsequence.
        //4. we transform original question into "finding the (k-1)th smallest sum of subsequence"
        //      eg: the 1th largest subsequnce will be "max - 0"
        //          the 2th largest subsequnce will be "max - 1th smallest sum of subsequence"
        //5. to get the kth smallest sum of subsequence in nlogn, 
        //   we will try to iterate sum of subsequnce in increasing order,
        //   then use a heap to store them
        //6. for an increasing array [a, b, c], we can choose draw a tree to interate it
        //          a
        //        /    \
        //     b         a+b
        //    / \       /   \
        //   c   b+c   a+c   a+b+c
        //7. interate in this way and find the (k-1)th smallest sum of subsequnce using heap
        //   answer will be max - (k-1)th smallest sum of subsequence
        
        
        long max = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0)
                max += nums[i];
            else
                nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        PriorityQueue<long[]> que = new PriorityQueue<>((n1, n2) -> (Long.compare(n1[0], n2[0])));
        que.offer(new long[]{nums[0], 0});

        long kmin = 0;
        for (int i = 1; i < k; i ++) {
            long[] node = que.poll();
            kmin = node[0];
            if (node[1] == nums.length - 1)
                continue;
            que.offer(new long[] {kmin + nums[(int)node[1]+1], node[1]+1});
            que.offer(new long[] {kmin - nums[(int)node[1]] + nums[(int)node[1]+1], node[1]+1});
        }
        
        return max - kmin;
    }
}
