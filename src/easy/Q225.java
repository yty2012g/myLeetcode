package easy;

import java.util.*;

/*
 * 2016.7.19
 * 这里使用queue来模仿stack，并且要求只允许使用queue的基本操作。
 * pop操作和queue的poll一致。
 * top操作和queue的peek一致。
 * empty操作和isEmpty一致
 * 对于push操作，先使用一个新的队列q2，将queue所有的元素按顺序存入q2，然后把新元素存到queue，再把q2的元素返回。
 * 原因在于queue每次只能弹出队头元素，所以每次新加入的元素需要放在队头。
 */
public class Q225 {
	class MyStack {
		// Push element x onto stack.
		Queue<Integer> queue = new LinkedList<Integer>();

		public void push(int x) {
			Queue<Integer> q2 = new LinkedList<Integer>();
			while (!queue.isEmpty()) {
				q2.offer(queue.poll());
			}
			queue.offer(x);
			while (!q2.isEmpty()) {
				queue.offer(q2.poll());
			}
		}

		// Removes the element on top of the stack.
		public void pop() {
			queue.poll();
		}

		// Get the top element.
		public int top() {
			return queue.peek();
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue.isEmpty();
		}
	}
}
