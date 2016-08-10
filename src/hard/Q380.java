package hard;

import java.util.*;

/*
 * 2016.8.10
 * 这个题目是使用arraylist和hashmap相结合。
 * 使用list记录已经出现的数字，其中size记为有效数字的数量。
 * map记录这个数字出现的次数，如果对某一数字使用remove操作，则对应出现的次数置为0；
 * pos记录这个数字在list中的位置，为了保证O（1）的时间复杂度，就不能采取遍历list的方法。
 * 
 * 在insert方法中，如果这个数字出现的次数为0，或者就没出现过，则可以添加到list中，如果此时list没有删除过，那么直接添加到最后即可。
 * 如果删除过，则list.size不等于size，此时，先将数字加入list最后一位，然后和size位的数字进行交换，最后size++即可，和快速排序的partition类似。
 * 
 * 在remove方法中，如果这个数字出现的次数为0，或者没有出现过，返回false；
 * 否则，找到这个数字的位置po，将po位置和size-1位置的数字交换，注意，这里在pos表中也要修改size-1位置数字的位置。size--即可。
 * 
 * 在random方法中，不能使用Math.Random()，要使用java.util.Random类的nextInt()方法。
 */
public class Q380 {
	public class RandomizedSet {
		public ArrayList<Integer> list = new ArrayList<Integer>();
		public HashMap<Integer, Integer> map;
		public HashMap<Integer, Integer> pos;
		public int size = 0;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			this.list = new ArrayList<Integer>(100);
			this.map = new HashMap<Integer, Integer>(100);
			this.pos = new HashMap<Integer, Integer>(100);
			this.size = 0;
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already
		 * contain the specified element.
		 */
		public boolean insert(int val) {
			Integer times = map.get(val);
			if (times == null || times.equals(0)) {
				if (size == this.list.size()) {
					size++;
					list.add(val);
					map.put(val, 1);
				} else {
					list.add(val);
					list.set(list.size() - 1, list.get(size));
					list.set(size, val);
					size++;
					map.put(val, 1);
				}
				pos.put(val, size - 1);
				System.out.println(list);
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the
		 * specified element.
		 */
		public boolean remove(int val) {
			Integer times = map.get(val);
			if (times == null || times.equals(0)) {
				return false;
			} else {
				map.put(val, 0);
				int po = pos.get(val);
				pos.put(list.get(size - 1), po);
				list.set(po, list.get(size - 1));
				list.set(size - 1, val);
				size--;
				return true;
			}
		}

		/** Get a random element from the set. */
		public int getRandom() {
			java.util.Random ra = new java.util.Random();
			return list.get(ra.nextInt(this.size));
		}
	}
}
