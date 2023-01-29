package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateSubsetTwoLeetCode90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateSubsetTwoLeetCode90 obj = new GenerateSubsetTwoLeetCode90();
		
		int[] nums = {1,2,2};
		List<List<Integer>> ans = obj.subsetsWithDup(nums);
		System.out.println("Subsets :: "+ans.toString());
		
		return;
	}

	/*
	 * Each recursion level focuses on all the following elements. We scan through
	 * all the following elements and decide whether to choose or not choose that
	 * element. (Every level split into N branches.)
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    
		list.add(new ArrayList<>(tempList));
	    
	    for(int i = start; i < nums.length; i++){
	    	
	    	if(i > start && nums[i]==nums[i-1]) continue;
	    	
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}

	/*
	 * Each recursion level focuses on one element, we need to decide choose or not
	 * choose this element. (Every level split into 2 branches.)
	 */
	public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0,false);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos, boolean choosePre) {
        if(pos==nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        helper(res,ls,nums,pos+1,false);
        if(pos>=1&&nums[pos]==nums[pos-1]&&!choosePre) return;
        ls.add(nums[pos]);
        helper(res,ls,nums,pos+1,true);
        ls.remove(ls.size()-1);
    }

}
