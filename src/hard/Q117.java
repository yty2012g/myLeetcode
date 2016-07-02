package hard;

import basicDataStructure.TreeLinkNode;

/*
 * 2016.7.2
 * ��Q116���ƣ����ǲ���������ͬ������Q116������ȫ��������Ҳ������һ�е�����ڵ�һ���Ǳ�������ڵ�����ӽڵ㡣
 * ����Q117��һ���������ʹ��NextmostLeft��¼��һ�е�һ�γ��ֵķǿսڵ㡣
 * ����Q116���ԣ�ÿһ���ڵ㶼�������ӽڵ㣬����cur.right.next����curNext.left�����curNext�ǿյĻ���
 * ����Q117��һ������������ǲ���֪��curNext�Ƿ������ӽڵ�������ӽڵ㡣���ʹ��nextCur��¼��һ�У��Ѿ���������һ���ڵ㡣
 * ��ʱ�����cur����ڵ㣬��ônextCur��nextָ��ָ����ڵ㣬����nextCur���nextCur��next�������ִ�����һ���ڵ㡣
 * �������һ�е��жϣ���Ȼ��curNextΪ�գ�ͬʱnextCurҲΪ�գ���ΪnextCur������һ���Ѿ���������һ���ڵ㡣
 */
public class Q117 {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		else {
			root.next = null;
			c(null, null, root, root.next);
		}
	}

	public void c(TreeLinkNode NextmostLeft, TreeLinkNode nextCur, TreeLinkNode cur, TreeLinkNode curNext) {
		if (NextmostLeft == null) {
			if (cur.left != null) {
				NextmostLeft = cur.left;
			} else if (cur.right != null) {
				NextmostLeft = cur.right;
			}
		}
		if (nextCur == null) {
			if (cur.left != null) {
				nextCur = cur.left;
			} else if (cur.right != null) {
				nextCur = cur.right;
			}
		}
		if (curNext == null) {
			if (cur.left == null && cur.right == null) {
				if (nextCur == null)
					return;
				else {
					nextCur.next = null;
					c(null, null, NextmostLeft, NextmostLeft.next);
					return;
				}
			} else {
				if (cur.left != null) {
					nextCur.next = cur.left;
					nextCur = nextCur.next;
				}
				if (cur.right != null) {
					nextCur.next = cur.right;
					nextCur = nextCur.next;
				}
				nextCur.next = null;
				c(null, null, NextmostLeft, NextmostLeft.next);
				return;
			}
		} else {
			if (cur.left != null) {
				nextCur.next = cur.left;
				nextCur = nextCur.next;
			}
			if (cur.right != null) {
				nextCur.next = cur.right;
				nextCur = nextCur.next;
			}
			c(NextmostLeft, nextCur, curNext, curNext.next);
		}
	}
}
