package My_Learning.Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
Output : 7
Explanation :
3rd smallest element in the given 
array is 7.*/

public class KthSmallestElement {

	public static void main(String[] args) {
		// getting input stream object
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the size of array :: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Please enter the elemnets for array :: ");
		for(int i = 0 ; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans = printKSmallest(arr, size);
		System.out.println(ans);
		
		sc.close();

	}

	private static int printKSmallest(int[] arr, int k) {
		
		Arrays.sort(arr);
		
		return arr[k-1];
	}

}
