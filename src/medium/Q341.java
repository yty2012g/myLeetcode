package medium;

import basicDataStructure.*;
import java.util.*;

/*
 * 2016.8.26
 * 这个题目，我的做法就是把nextedInteger拉平，然后放到一个arraylist里面，然后直接调用arraylist的iterator即可。
 */
public class Q341 {
	public class NestedIterator implements Iterator<Integer> {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Iterator<Integer> iter;

		public NestedIterator(List<NestedInteger> nestedList) {
			make(nestedList);
			iter = res.iterator();
		}

		@Override
		public Integer next() {
			return iter.next();
		}

		@Override
		public boolean hasNext() {
			return iter.hasNext();
		}

		public void make(List<NestedInteger> nestedList) {
			for (NestedInteger ele : nestedList) {
				if (ele.isInteger())
					res.add(ele.getInteger());
				else
					make(ele.getList());
			}
		}
	}
}
