package hard;

import java.util.*;

/*
 * 2016.8.10
 * ��Q380�ķ��������Ƶģ�ʹ��map��ǳ��ֵ����ֺ����Ĵ�����pos��ǳ��ֵ����ֺ�λ��list��list��¼���ֵ����֡�
 * ����insert������������ֹ�������ִ���+1��λ��list�������µ�λ�á����򣬳��ִ���Ϊ1�������µ�λ��list�����µ����ּ���list�����һ����
 * ����remove������������ִ���Ϊ0����û�г��ֹ�����ֱ�ӷ���false��
 * �������ɾ����Ԫ�������һ������ֱ��ɾ��list���һ��Ԫ�ؼ��ɣ���Ӧ��pos�����λ��listҲҪ�Ƴ���Ӧ��λ�á�
 *       ����������һ������ô�����һ��Ԫ�غ�Ҫɾ��Ԫ�صĵ�һ��λ�ý��н�������ʱ��Ҫ�ı����һ��Ԫ����pos�����λ����Ϣ��Ȼ��ɾ��list���һ��Ԫ�ء�
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
