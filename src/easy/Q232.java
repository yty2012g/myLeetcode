package easy;

import java.util.*;

/*
 * 2016.7.19
 * ���ö���ģ��ջ���ơ���
 * pop��peek��empty������ջ�Ĳ�����
 * push�������Ƚ�stack���е����ݵ���helpջ�У�stack�����µ����ݣ��ٰ�help�����ݵ�������ȷ���µ�������ջ�ס�
 */
public class Q232 {
	class MyQueue {
		Stack<Integer> stack = new Stack<Integer>();

		// Push element x to the back of queue.
		public void push(int x) {
			if (stack.empty())
				stack.push(x);
			else {
				Stack<Integer> help = new Stack<Integer>();
				while (!stack.isEmpty()) {
					help.push(stack.pop());
				}
				stack.push(x);
				while (!help.empty()) {
					stack.push(help.pop());
				}
			}
		}

		// Removes the element from in front of queue.
		public void pop() {
			stack.pop();
		}

		// Get the front element.
		public int peek() {
			return stack.peek();
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return stack.isEmpty();
		}
	}
}
