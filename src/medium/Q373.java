package medium;

import java.util.*;

/*
 * 2016.8.15
 * 这个题目就是利用大根堆，题目可以抽象为求最小的k个数。
 * 建立一个容量为k的大根堆，如果元素小于k，则直接加入堆中。
 * 如果等于k，并且堆顶元素大于当前元素，则将堆顶移除，并且加入当前元素。
 * 最终得到最小的k个数字
 */
public class Q373 {
	public class node {
		public int f = 0;
		public int s = 0;

		public node(int f, int s) {
			this.f = f;
			this.s = s;
		}

		public int[] re() {
			int[] res = new int[2];
			res[0] = f;
			res[1] = s;
			return res;
		}
	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> list = new ArrayList<int[]>(k);
		Comparator<node> comp = new Comparator<node>() {
			@Override
			public int compare(node arg0, node arg1) {
				// TODO Auto-generated method stub
				if (arg0.f + arg0.s == arg1.f + arg1.s)
					return 0;
				else if ((arg0.f + arg0.s > arg1.f + arg1.s))
					return -1;
				else
					return 1;
			}
		};
		PriorityQueue<node> pq = new PriorityQueue<node>(k + 1, comp);
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				node n = new node(nums1[i], nums2[j]);
				if (pq.size() != k) {
					pq.add(n);
				} else {
					if (comp.compare(n, pq.peek()) > 0) {
						pq.poll();
						pq.add(n);
					}
				}

			}
		}
		Iterator<node> iter = pq.iterator();
		while (iter.hasNext()) {
			list.add(iter.next().re());
		}
		return list;
	}
}
