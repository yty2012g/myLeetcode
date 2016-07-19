package easy;

import java.util.*;

/*
 * 2016.7.19
 * ����ʹ��queue��ģ��stack������Ҫ��ֻ����ʹ��queue�Ļ���������
 * pop������queue��pollһ�¡�
 * top������queue��peekһ�¡�
 * empty������isEmptyһ��
 * ����push��������ʹ��һ���µĶ���q2����queue���е�Ԫ�ذ�˳�����q2��Ȼ�����Ԫ�ش浽queue���ٰ�q2��Ԫ�ط��ء�
 * ԭ������queueÿ��ֻ�ܵ�����ͷԪ�أ�����ÿ���¼����Ԫ����Ҫ���ڶ�ͷ��
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
