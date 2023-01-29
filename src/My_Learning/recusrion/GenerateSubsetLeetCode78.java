package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateSubsetLeetCode78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateSubsetLeetCode78 obj = new GenerateSubsetLeetCode78();
		
		int[] nums = {1,2,2};
		List<List<Integer>> ans = obj.subsets(nums);
		System.out.println("Subsets :: "+ans.toString());
		
		return;
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		
		findSubset(0, nums, ans, new ArrayList<>());
		
		return ans;
	}
	
	private void findSubset(int index, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
		
		if(index == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		
		ds.add(nums[index]);
		findSubset(index+1, nums, ans, ds);
		ds.remove(ds.size() - 1);
		
		findSubset(index+1, nums, ans, ds);
		
		return;
		
	}
	
	//method - 2
	
	public List<List<Integer>> subsets2(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}

}
