package hard;

import java.util.*;

/*
 * 2016.7.5
 * 这个题目是实现LRU置换算法。LRU就是淘汰最先加入的页面。题目要求实现get方法和set方法。
 *                                  *** 注意！！***
 *              1. 在get方法中，也要按照访问顺序调整页面位置，即放到链表的队尾
 *              2. 在set方法和get方法中都应用了O(1)时间复杂度的链表删除算法。但是一定要在hashmap中做同样的修改。
 *              3. 使用tail指向链表的尾节点，否则无法在O（1）时间复杂度删除尾节点。
 * 
 *  算法比较简单。在set方法中，首先判断key值是否存在。
 *  如果不存在，判断目前链表的长度是否已经满了。如果满了，就删除头节点
 *                                              如果没有满，则直接加入链表尾部，同时把key值更新至hashmap中。
 *  如果key存在，那么先将key值对应的那个节点删除，这里用的O（1）的方法，即将该节点和next节点的值交换。注意，这里要更新hashmap
 *               然后，新生成一个key-value节点，加入队尾即可。
 *  get方法比较简单，如果hashmap中找不到，直接返回-1；如果找得到，删除节点，新生成一个节点，加入链表尾部。返回value值。
 *  
 *  这里使用Node内部类实现了一个链表的功能。主要原因是LinkedList类的remove方法不是O(1)的，所以大数据通不过。
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
