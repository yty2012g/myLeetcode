package medium;

import basicDataStructure.*;
import java.util.*;

/*
 * 2016.8.26
 * �����Ŀ���ҵ��������ǰ�nextedInteger��ƽ��Ȼ��ŵ�һ��arraylist���棬Ȼ��ֱ�ӵ���arraylist��iterator���ɡ�
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
