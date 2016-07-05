package hard;

import java.util.*;

/*
 * 2016.7.5
 * �����Ŀ��ʵ��LRU�û��㷨��LRU������̭���ȼ����ҳ�档��ĿҪ��ʵ��get������set������
 *                                  *** ע�⣡��***
 *              1. ��get�����У�ҲҪ���շ���˳�����ҳ��λ�ã����ŵ�����Ķ�β
 *              2. ��set������get�����ж�Ӧ����O(1)ʱ�临�Ӷȵ�����ɾ���㷨������һ��Ҫ��hashmap����ͬ�����޸ġ�
 *              3. ʹ��tailָ�������β�ڵ㣬�����޷���O��1��ʱ�临�Ӷ�ɾ��β�ڵ㡣
 * 
 *  �㷨�Ƚϼ򵥡���set�����У������ж�keyֵ�Ƿ���ڡ�
 *  ��������ڣ��ж�Ŀǰ����ĳ����Ƿ��Ѿ����ˡ�������ˣ���ɾ��ͷ�ڵ�
 *                                              ���û��������ֱ�Ӽ�������β����ͬʱ��keyֵ������hashmap�С�
 *  ���key���ڣ���ô�Ƚ�keyֵ��Ӧ���Ǹ��ڵ�ɾ���������õ�O��1���ķ����������ýڵ��next�ڵ��ֵ������ע�⣬����Ҫ����hashmap
 *               Ȼ��������һ��key-value�ڵ㣬�����β���ɡ�
 *  get�����Ƚϼ򵥣����hashmap���Ҳ�����ֱ�ӷ���-1������ҵõ���ɾ���ڵ㣬������һ���ڵ㣬��������β��������valueֵ��
 *  
 *  ����ʹ��Node�ڲ���ʵ����һ������Ĺ��ܡ���Ҫԭ����LinkedList���remove��������O(1)�ģ����Դ�����ͨ������
 * 
 */
public class Q146 {
	public class LRUCache {
		public class Node {
			public int key;
			public int value;
			public Node next;

			public Node(int key, int value) {
				this.key = key;
				this.value = value;
				this.next = null;
			}

			public void print(Node t) {
				while (t != null) {
					System.out.print("(" + t.key + "," + t.value + ")" + "->");
					t = t.next;
				}
				System.out.println();
			}
		}

		public Node head;
		public Node tail;
		public HashMap<Integer, Node> map;
		public int cur;
		public int capacity;

		public LRUCache(int capacity) {
			this.map = new HashMap<Integer, Node>();
			this.cur = 0;
			this.capacity = capacity;
			this.head = new Node(0, 0);
			this.tail = head;
		}

		public int get(int key) {
			if (map.get(key) == null)
				return -1;
			Node node = map.get(key);
			int value = node.value;
			if (node.next != null) {
				Node next = node.next;
				if (tail == next)
					tail = node;
				node.next = next.next;
				node.key = next.key;
				node.value = next.value;
				Node temp = new Node(key, value);
				tail.next = temp;
				tail = tail.next;
				map.put(node.key, node);
				map.put(key, temp);
			}
			return value;
		}

		public void set(int key, int value) {
			if (map.get(key) == null) {
				if (cur == capacity) {
					map.remove(head.next.key);
					if (head.next == tail)
						tail = head;
					head.next = head.next.next;
					cur--;
				}
				Node node = new Node(key, value);
				tail.next = node;
				tail = tail.next;
				map.put(key, node);
				cur++;
			} else {
				Node node = map.get(key);
				if (node.next != null) {
					Node next = node.next;
					if (tail == next)
						tail = node;
					node.next = next.next;
					node.key = next.key;
					node.value = next.value;
					Node temp = new Node(key, value);
					tail.next = temp;
					tail = tail.next;
					map.put(node.key, node);
					map.put(key, temp);
				} else {
					node.value = value;
				}
			}
		}
	}
}
