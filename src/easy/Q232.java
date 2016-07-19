package easy;

import java.util.*;

/*
 * 2016.7.19
 * 和用队列模仿栈类似。。
 * pop，peek，empty都采用栈的操作。
 * push操作，先将stack所有的数据倒入help栈中，stack加入新的数据，再把help的数据倒回来，确保新的数据在栈底。
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
