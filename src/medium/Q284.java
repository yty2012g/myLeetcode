package medium;

import java.util.*;

/*
 * 2016.7.26
 * 使用一个boolean型变量haspeek记录是否已经peek过。peeked记录peek值。
 * 对于peek操作，如果有下一个，则返回next()，haspeek设为true，peeked记录当前值，然后当前值即可。如果没有下一个，返回null
 * 对于next操作，如果haspeek为true，则返回peeked值，并将haspeek设置为false，否则，直接返回it.next（）值。
 * 对于hasNext操作，如果haspeek为true，返回true。或者it.hasNext()返回true，则返回true；
 */
public class Q284 {
	class PeekingIterator implements Iterator<Integer> {
		public boolean haspeek;
		public Integer peeked;
		public Iterator<Integer> it;

		public PeekingIterator(Iterator<Integer> iterator) {
			// initialize any member here.
			this.it = iterator;
			haspeek = false;
			peeked = null;
		}

		// Returns the next element in the iteration without advancing the
		// iterator.
		public Integer peek() {
			if (hasNext()) {
				Integer res = next();
				haspeek = true;
				peeked = res;
				return res;
			} else
				return null;
		}

		// hasNext() and next() should behave the same as in the Iterator
		// interface.
		// Override them if needed.
		@Override
		public Integer next() {
			if (haspeek) {
				Integer res = peeked;
				peeked = null;
				haspeek = false;
				return res;
			} else {
				return it.next();
			}
		}

		@Override
		public boolean hasNext() {
			return haspeek || it.hasNext();
		}
	}
}
