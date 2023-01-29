package My_Learning.dynamicProgramming;

public class NumberSmallerThanCurrentLeetCode1365 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//  public int[] smallerNumbersThanCurrent(int[] nums) {

//     Map<Integer, Integer> map = new HashMap<>();
//     int[] copy = nums.clone();

//     Arrays.sort(copy);

//     for (int i = 0; i < nums.length; i++) {
//         map.putIfAbsent(copy[i], i);
//     }

//     for (int i = 0; i < nums.length; i++) {
//         copy[i] = map.get(nums[i]);
//     }

//     return copy;

// }

//  public int[] smallerNumbersThanCurrent(int[] nums) {
//     int[] count = new int[101];
//     int[] res = new int[nums.length];

//     for (int i =0; i < nums.length; i++) {
//         count[nums[i]]++;
//     }

//     for (int i = 1 ; i <= 100; i++) {
//         count[i] += count[i-1];    
//     }

//     for (int i = 0; i < nums.length; i++) {
//         if (nums[i] == 0)
//             res[i] = 0;
//         else 
//             res[i] = count[nums[i] - 1];
//     }

//     return res;        
//}

	public int[] smallerNumbersThanCurrent(int[] nums) {

		int[] bucket = new int[102];
		for (int i = 0; i < nums.length; i++)
			bucket[nums[i] + 1]++;

		for (int i = 0; i < 101; i++)
			bucket[i + 1] += bucket[i];

		for (int i = 0; i < nums.length; i++)
			nums[i] = bucket[nums[i]];

		return nums;
	}

}
