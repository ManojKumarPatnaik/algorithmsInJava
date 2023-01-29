package My_Learning.queues;

import java.util.Iterator;

public class PeekingIteratorLeetcode284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Integer cache = null;
	Iterator<Integer> it;

	public PeekingIteratorLeetcode284(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    cache = it.next();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		int ret = cache;
		if (it.hasNext()) {
			cache = it.next();
		} else {
			cache = null;
		}
		return ret;
	}

	public boolean hasNext() {
		return (cache != null);
	}

}
