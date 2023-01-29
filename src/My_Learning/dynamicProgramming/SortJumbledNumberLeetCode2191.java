package My_Learning.dynamicProgramming;

import java.util.*;

public class SortJumbledNumberLeetCode2191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//  public int[] sortJumbled(int[] mapping, int[] nums) {
//      int[] arr = new int[nums.length];

//      for(int i = 0; i < nums.length; i++){
//          int t = nums[i];

//          //gettign the mapped value
//          int mapValue = getMappedValue(mapping, nums[i]);

//          arr[i] = mapValue;
//      }

//      Arrays.sort(arr);

//      return arr;
//  }

//  public int getMappedValue(int[] mapping, int num){

//      int mappedValue = 0;
//      while(num!=0){
//          int digit = num%10;
//          mappedValue = mappedValue*10 + mapping[digit];
//          num = num / 10;
//      } // 991 -> 966 -> 669

//      int finalMappedValue = 0;
//      while(mappedValue!=0){
//          int digit = mappedValue%10;
//          finalMappedValue = finalMappedValue*10 + digit;
//          mappedValue = mappedValue/10;
//      }

//      System.out.println(finalMappedValue);
//      return finalMappedValue;
//  }

	public int[] sortJumbled(int[] mapping, int[] nums) {
		int arr[] = new int[nums.length];
		int index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			StringBuffer sb = new StringBuffer();
			for (char c : (num + "").toCharArray()) {
				sb.append(mapping[c - '0']);
			}
			list.add(new int[] { nums[i], Integer.parseInt(sb.toString()), i });
		}
		Collections.sort(list, (a, b) -> (b[1] - a[1] == 0) ? a[2] - b[2] : a[1] - b[1]);
		List<Integer> resultList = new ArrayList<>();

		for (int[] val : list)
			resultList.add(nums[val[2]]);

		return resultList.stream().mapToInt(Integer::intValue).toArray();
	}

}
