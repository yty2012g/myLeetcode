package medium;

import java.util.*;

/*
 * 2016.7.26
 * ʹ��һ��boolean�ͱ���haspeek��¼�Ƿ��Ѿ�peek����peeked��¼peekֵ��
 * ����peek�������������һ�����򷵻�next()��haspeek��Ϊtrue��peeked��¼��ǰֵ��Ȼ��ǰֵ���ɡ����û����һ��������null
 * ����next���������haspeekΪtrue���򷵻�peekedֵ������haspeek����Ϊfalse������ֱ�ӷ���it.next����ֵ��
 * ����hasNext���������haspeekΪtrue������true������it.hasNext()����true���򷵻�true��
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
