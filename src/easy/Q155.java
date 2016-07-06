package easy;

import java.util.*;

/*
 * 2016.7.6
 * ����������stack�����ȼ����У�С���ѣ������ݽṹ��
 * push�����ܼ򵥣��Ƚϵ�ǰֵ��min�������ǰֵ��С�����min��Ȼ����ǲ���stack���������ȼ����С�
 * pop������Ҫע�⡣����stack�Ĳ�����ֻ��һ����ջ���ѡ����������Ԫ�غ���СԪ����ȣ�����Ҫ�����ȼ����е�ͷҲ����������min
 * top��������peek
 * getMin���Ƿ���minԪ�ؼ��ɡ�
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
