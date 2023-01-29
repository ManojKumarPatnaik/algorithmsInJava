package My_Learning.hashing;

import java.util.HashMap;

public class HashMapCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating the hashMap object
		HashMap<Integer,String> map = new HashMap<>();
		
		map.put(1,"ujjwal");
		map.put(2,"Ram");
		
		map.remove(2);
		
		System.out.println("Default Size created before adding object :: "+map.size());

	}

}
