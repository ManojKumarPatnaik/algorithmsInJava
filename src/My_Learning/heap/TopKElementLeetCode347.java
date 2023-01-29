package My_Learning.heap;

import java.util.*;

public class TopKElementLeetCode347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Input: nums = [1,1,1,2,2,3], k = 2
//				Output: [1,2]
		
		int[] nums = {1,1,1,1,1,1,1,1,1,2,2,3,3,3,3,3,3,3,3,3};
		int k = 2;
		
		int[] ans = topKFrequent(nums, k);
		System.out.println(Arrays.toString(ans));
				
	}

	// using bucket sort TC - O(n)
	@SuppressWarnings("unchecked")
	public static int[] topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		System.out.println("Map :: "+hm.entrySet());
		
		for (int key : hm.keySet()) {
			int frequency = hm.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		
		int c = 0;
		for(List<Integer> i : bucket) {
			c++;
			if(i!=null)
				System.out.println(i.toString());
		}
		System.out.println("Bucket Size :: "+c);
		
		int ans[] = new int[k];
		int count = 0;
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (int j = 0; j < bucket[i].size(); j++)
					ans[count++] = bucket[i].get(j);
			}
			if (count == k)
				break;
		}

		return ans;
	}

	// using minimum heap or bounded size of k TC - O(klogk) smaller than nlogn
	public List<Integer> topKFrequentMinHeap(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
				(a, b) -> Integer.compare(a.getValue(), b.getValue()));
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(entry);
			if (minHeap.size() > k)
				minHeap.poll();
		}

		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			Map.Entry<Integer, Integer> entry = minHeap.poll();
			res.add(entry.getKey());
		}
		return res;
	}
	
	// using max heap TC - O(nlogn)
	public List<Integer> topKFrequentMaxHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
