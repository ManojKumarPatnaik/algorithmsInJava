package My_Learning.hashing;

import java.util.HashSet;

public class HashSetCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(2);
		set.add(null);
		
		set.add(null); // throw error only one null value is allowed
		
		System.out.println(set.toString());
	}

}
