package hard;

import java.util.*;

/*
 * 2016.8.10
 * 和Q380的方法是类似的，使用map标记出现的数字和他的次数，pos标记出现的数字和位置list，list记录出现的数字。
 * 对于insert方法，如果出现过，则出现次数+1，位置list加入最新的位置。否则，出现次数为1，生成新的位置list。把新的数字加在list的最后一个。
 * 对于remove方法，如果出现次数为0或者没有出现过，则直接返回false；
 * 否则，如果删除的元素是最后一个，则直接删除list最后一个元素即可，对应的pos里面的位置list也要移除相应的位置。
 *       如果不是最后一个，那么将最后一个元素和要删除元素的第一个位置进行交换，此时需要改变最后一个元素在pos里面的位置信息。然后删除list最后一个元素。
 */
public class Q381 {
	public class RandomizedCollection {
		HashMap<Integer, LinkedList<Integer>> pos = new HashMap<Integer, LinkedList<Integer>>(1024);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(1024);
		LinkedList<Integer> list = new LinkedList<Integer>();

		/** Initialize your data structure here. */
		public RandomizedCollection() {

		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did
		 * not already contain the specified element.
		 */
		public boolean insert(int val) {
			Integer times = map.get(val);
			LinkedList<Integer> p;
			if (times == null || times.equals(0)) {
				map.put(val, 1);
				p = new LinkedList<Integer>();
			} else {
				map.put(val, times + 1);
				p = pos.get(val);
			}
			list.add(val);
			p.add(list.size() - 1);
			pos.put(val, p);
			return map.get(val) == 1;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection
		 * contained the specified element.
		 */
		public boolean remove(int val) {
			System.out.println(list);
			Integer times = map.get(val);
			if (times == null || times == 0) {
				return false;
			} else {
				int firstPos = pos.get(val).removeFirst();
				if (firstPos != list.size() - 1) {
					pos.get(list.getLast()).remove((Integer) list.size() - 1);
					pos.get(list.getLast()).add(firstPos);
					list.set(firstPos, list.getLast());
				}
				list.removeLast();
				map.put(val, times - 1);
				return true;
			}
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			java.util.Random ra = new java.util.Random();
			return list.get(ra.nextInt(list.size()));
		}
	}
}
