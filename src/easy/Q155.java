package easy;

import java.util.*;

/*
 * 2016.7.6
 * 这里利用了stack和优先级队列（小根堆）的数据结构。
 * push方法很简单，比较当前值和min，如果当前值更小则更新min。然后就是插入stack，插入优先级队列。
 * pop方法需要注意。对于stack的操作，只是一个弹栈而已。如果弹出的元素和最小元素相等，就需要把优先级队列的头也弹出并更新min
 * top方法就是peek
 * getMin就是返回min元素即可。
 * 
 */
public class Q155 {
	public class MinStack {

		/** initialize your data structure here. */
		public Stack<Integer> stack;
		public PriorityQueue<Integer> queue;
		public int min;

		public MinStack() {
			this.stack = new Stack<Integer>();
			this.min = 0;
			this.queue = new PriorityQueue<Integer>();
		}

		public void push(int x) {
			if (stack.size() == 0 || min > x)
				min = x;
			stack.push(x);
			queue.offer(x);
		}

		public void pop() {
			int x = stack.pop();
			if (x == min) {
				queue.poll();
				min = queue.peek();
			}
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return this.min;
		}
	}
}
