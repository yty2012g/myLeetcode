package medium;

import basicDataStructure.TreeLinkNode;
/*
 * 2016.7.2
 * 使用递归的做法。使用mostLeft记录该行的最左边的元素。使用cur记录当前处理的元素。使用curNext记录cur的next指针指向的元素。
 * 终止条件是，树的最底层就结束。
 * 如果curNext是null表明要换行了。
 * 对于每一个cur，将左节点的next指向右节点。如果curNext为null，则右节点指向null。否则指向curNext的左节点。
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
