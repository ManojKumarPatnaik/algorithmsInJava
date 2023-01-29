package My_Learning.Arrays3;

public class SingleElementInSorted_arrLeetvcode540 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int singleNonDuplicate(int[] nums) {
        int l=0, r=nums.length-1, mid;
        
        while (l<r){
            mid = l + (r-l)/2;
            
            if (mid%2==1) --mid;
            if (nums[mid]==nums[mid+1]) l = mid+2;
            else r=mid;
        }
        return nums[l];
    }

}
