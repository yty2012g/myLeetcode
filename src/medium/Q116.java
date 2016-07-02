package medium;

import basicDataStructure.TreeLinkNode;
/*
 * 2016.7.2
 * ʹ�õݹ��������ʹ��mostLeft��¼���е�����ߵ�Ԫ�ء�ʹ��cur��¼��ǰ�����Ԫ�ء�ʹ��curNext��¼cur��nextָ��ָ���Ԫ�ء�
 * ��ֹ�����ǣ�������ײ�ͽ�����
 * ���curNext��null����Ҫ�����ˡ�
 * ����ÿһ��cur������ڵ��nextָ���ҽڵ㡣���curNextΪnull�����ҽڵ�ָ��null������ָ��curNext����ڵ㡣
 */
public class Q116 {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		else {
			root.next = null;
			c(root, root, root.next);
		}
	}

	public void c(TreeLinkNode mostLeft, TreeLinkNode cur, TreeLinkNode curNext) {
		if (mostLeft == null || mostLeft.left == null)
			return;
		if (curNext == null) {
			cur.left.next = cur.right;
			cur.right.next = null;
			c(mostLeft.left, mostLeft.left, mostLeft.right);
			return;
		}
		cur.left.next = cur.right;
		cur.right.next = curNext.left;
		c(mostLeft, curNext, curNext.next);
	}
}
