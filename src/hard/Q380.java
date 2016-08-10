package hard;

import java.util.*;

/*
 * 2016.8.10
 * �����Ŀ��ʹ��arraylist��hashmap���ϡ�
 * ʹ��list��¼�Ѿ����ֵ����֣�����size��Ϊ��Ч���ֵ�������
 * map��¼������ֳ��ֵĴ����������ĳһ����ʹ��remove���������Ӧ���ֵĴ�����Ϊ0��
 * pos��¼���������list�е�λ�ã�Ϊ�˱�֤O��1����ʱ�临�Ӷȣ��Ͳ��ܲ�ȡ����list�ķ�����
 * 
 * ��insert�����У����������ֳ��ֵĴ���Ϊ0�����߾�û���ֹ����������ӵ�list�У������ʱlistû��ɾ��������ôֱ����ӵ���󼴿ɡ�
 * ���ɾ��������list.size������size����ʱ���Ƚ����ּ���list���һλ��Ȼ���sizeλ�����ֽ��н��������size++���ɣ��Ϳ��������partition���ơ�
 * 
 * ��remove�����У����������ֳ��ֵĴ���Ϊ0������û�г��ֹ�������false��
 * �����ҵ�������ֵ�λ��po����poλ�ú�size-1λ�õ����ֽ�����ע�⣬������pos����ҲҪ�޸�size-1λ�����ֵ�λ�á�size--���ɡ�
 * 
 * ��random�����У�����ʹ��Math.Random()��Ҫʹ��java.util.Random���nextInt()������
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
