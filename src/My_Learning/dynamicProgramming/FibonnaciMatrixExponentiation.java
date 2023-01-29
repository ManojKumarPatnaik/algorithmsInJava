package My_Learning.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class FibonnaciMatrixExponentiation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// give n very large find the nth fibonnaci number
		
		int n = 15;
		
		int ans = getNthFibo(n);
		System.out.println(n+"th Fibonnaci term is "+ans);
	}

	private static int getNthFibo(int n) {
		// here we go for matrix exponentiation
		// f(n) = | 1 1 | x | f(1) | where matrix power raise to n-1
	  // f(n-1) = | 1 0 |   | f(0) | 
		
		// or simply do matrix power n and return the 1st row last item
		if(n==0) return 0;
		if(n==1) return 1;
	
		
		int[][] m = {{1,1},{1,0}};
		
		// now m ^ n nikal na h
		// normal concept h multiply m with m, n times 
		// I will go for binary exponentiation with advance version DP
		String binaryN = Integer.toBinaryString(n); // 13 - 1101 => (21)^13 = (21)^8 + (21)^4 + (21)^1 
		// now making a DP of map which will hold the set bit position
		Map<Double, int[][]> dpMap = new HashMap<Double, int[][]>();
		int c = 0;
		for(int i = binaryN.length() -1 ; i >=0; i--) {
			if(binaryN.charAt(i)!='0') {
				// means current index bit is set
				double powerMatrix = Math.pow(2, c);
				
				int[][] calcM = multiply(m, powerMatrix, dpMap);
			}
			c++;
		}
		
		return 0;
	}

	private static int[][] multiply(int[][] m, double powerMatrix, Map<Double, int[][]> dpMap) {
		
		if(powerMatrix==1) return dpMap.put(powerMatrix, m);
		
		if(powerMatrix%2!=0) {
			// means power is odd so
			if(!dpMap.containsKey(powerMatrix/2)) {
				int[][] temp = multiply(m, powerMatrix/2,dpMap) ;
				
				dpMap.put(powerMatrix/2, temp);
			} else {
				return dpMap.get(powerMatrix/2);
			}
			
			
		}
		
		return null;
	}

}
