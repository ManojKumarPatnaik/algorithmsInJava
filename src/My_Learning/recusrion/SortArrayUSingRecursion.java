package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;

public class SortArrayUSingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> arr = new ArrayList<>();
		
		arr.add(15);
		arr.add(3);
		arr.add(53);
		arr.add(2);
		arr.add(6);
		arr.add(33);
		
		System.out.println("Array without sorted  :: "+arr.toString()); //[15, 3, 53, 2, 6, 33]
		sort(arr);
		System.out.println("Array After sorting  :: "+arr.toString()); //[15, 3, 53, 2, 6, 33]


	}

	private static void sort(List<Integer> arr) {
		// TODO Auto-generated method stub
		
		if(arr.size()==1) return;
		
		int temp = arr.get(arr.size() - 1);
		arr.remove(arr.size() - 1);
		
		sort(arr); //calling at small input
		insert(arr, temp);
		return;
		
	}

	private static void insert(List<Integer> arrSorted, int temp) {
		// TODO Auto-generated method stub
		if(arrSorted.size() == 0 || arrSorted.get(arrSorted.size()-1) <= temp) {
			arrSorted.add(temp); // adding it in last or single element then return as it is.
			return;
		}
		
		int last = arrSorted.get(arrSorted.size() - 1);
		arrSorted.remove(arrSorted.size() - 1);
		
		insert(arrSorted, temp);
		arrSorted.add(last);
		return;
	}

}
