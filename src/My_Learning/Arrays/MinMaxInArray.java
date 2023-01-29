package My_Learning.Arrays;

import java.util.Scanner;

public class MinMaxInArray {

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
		
		findMinMax(arr, size);
		
		sc.close();
		

	}
	
	private static void findMinMax(int[] arr, int n) {
		
		int finalMax = Integer.MIN_VALUE;
		int finalMin = Integer.MAX_VALUE;
		
		for(int currentElement : arr) {
			
			if(currentElement > finalMax ) {
				finalMax = currentElement;
			}
			
			if(currentElement < finalMin ) {
				finalMin = currentElement;
			}
		}
		
		System.out.println("The Minimum & maximum value is :: [ "+ finalMin + ", "+ finalMax+ " ]");
	}

}
