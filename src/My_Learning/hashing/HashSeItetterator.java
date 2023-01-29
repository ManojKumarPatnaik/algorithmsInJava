package My_Learning.hashing;

import java.util.ArrayList;
import java.util.List;

public class HashSeItetterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Initialize your data structure here. */
	List<Integer> l;

	public HashSeItetterator() {
        l=new ArrayList<>();
    }

	public void add(int key) {
		if (l.contains(key) == false)
			l.add(key);
	}

	public void remove(int key) {
		if (l.contains(key))
			l.remove(l.indexOf(key));
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return l.contains(key);

	}

}
