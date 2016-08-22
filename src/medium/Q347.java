package medium;

import java.util.*;

/*
 * 2016.8.22
 * 两种方法：
 * 第一种，内建一个node类代表<num,times>的组合。利用一个容量为k的堆来存储。首先使用一个HashMap来统计每个元素出现的次数。
 * 然后遍历HashMap，生成node对象，放入堆中，这是一个小根堆，当当前容量不足k时，直接加入，否则当且仅当当前元素出现次数大于对顶元素的出现次数时，加入堆中。
 * 31ms。
 * 
 * 第二种，使用一个treeMap存储<times,List<num>>，一个Hashmap存储元素及其对应次数。
 * 当统计完次数后，将元素放入其对应次数的列表中。由于treeMap是有序的。然后使用迭代器遍历即可。
 * 119ms。
 */
public class Q347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		class node {
			int num;
			int times;

			node(int n, int t) {
				this.num = n;
				this.times = t;
			}
		}
		PriorityQueue<node> pq = new PriorityQueue<node>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				// TODO Auto-generated method stub
				return o1.times - o2.times;
			}
		});
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		int count = 0;
		for (int i : nums) {
			Integer t = map.get(nums[i]);
			if (t == null)
				map.put(nums[i], 1);
			else
				map.put(nums[i], t + 1);
		}
		Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, Integer> entry = iter.next();
			node temp = new node(entry.getKey(), entry.getValue());
			if (pq.size() < k) {
				pq.add(temp);
			} else if (pq.peek().times < temp.times) {
				pq.poll();
				pq.add(temp);
			}
		}
		List<Integer> res = new ArrayList<Integer>(k);
		while (pq.size() > 0) {
			res.add(pq.poll().num);
		}
		return res;
	}

	public List<Integer> topKFrequent2(int[] nums, int k) {
		TreeMap<Integer, List<Integer>> tree = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1 - arg0;
			}
		});
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		for (int i = 0, l = nums.length; i < l; i++) {
			Integer temp = map.get(i);
			if (temp == null) {
				map.put(nums[i], 1);
				List<Integer> list = tree.get(1);
				if (list == null) {
					list = new ArrayList<Integer>();
					tree.put(1, list);
				}
				list.add(nums[i]);
			} else {
				map.put(nums[i], temp + 1);
				tree.get(temp).remove((Integer) nums[i]);
				List<Integer> list = tree.get(temp + 1);
				if (list == null) {
					list = new ArrayList<Integer>();
					tree.put(temp + 1, list);
				}
				list.add(nums[i]);
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		Iterator<Map.Entry<Integer, List<Integer>>> iter = tree.entrySet().iterator();
		while (k > 0) {
			List<Integer> temp = iter.next().getValue();
			if (k > temp.size()) {
				res.addAll(temp);
				k -= temp.size();
			} else {
				res.addAll(temp.subList(0, k - 1));
				k = 0;
			}
		}
		return res;
	}
}
