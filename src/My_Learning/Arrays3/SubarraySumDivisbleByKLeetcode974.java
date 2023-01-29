package My_Learning.Arrays3;

public class SubarraySumDivisbleByKLeetcode974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,0,-2,-3,1};
	
		int k = 5;
		
		System.out.println(subarraysDivByK(nums, k));
	}
	
	public static int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
		map[0] = 1;
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum];
            map[sum]++;
        }
        return count;
    }

}
