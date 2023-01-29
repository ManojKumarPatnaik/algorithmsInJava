package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructRectangleleetcode492 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int area = 37;
		System.out.println(Arrays.toString(constructRectangle(area)));
	}

	public static int[] constructRectangle(int area) {
		List<Integer> possibleLW = new ArrayList<>();
		
		int temp = area/2;
		int i = 2;
		possibleLW.add(1);
		
		while(temp!=0) {
			if ( temp % i == 0) {
				temp = temp / i;
				possibleLW.add(i);
			}
			i++;
		}
		
		System.out.println(possibleLW.toString());
		
		return null;
	}
	
	public static int[] constructRectangle1(int area) {
        int[] result = new int[2];
        if(area == 0){
            return result;
        }
        int a = (int)Math.sqrt(area);
        while(area%a != 0){
            a--;
        }
        int b = area/a;
        result[0] = b;
        result[1] = a;
        return result;
    }

}
