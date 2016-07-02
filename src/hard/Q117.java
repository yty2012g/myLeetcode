package hard;

import basicDataStructure.TreeLinkNode;

/*
 * 2016.7.2
 * 和Q116类似，但是参数有所不同。由于Q116都是完全二叉树。也就是下一行的最左节点一定是本行最左节点的左子节点。
 * 但是Q117是一般二叉树。使用NextmostLeft记录下一行第一次出现的非空节点。
 * 对于Q116而言，每一个节点都有两个子节点，所以cur.right.next就是curNext.left。如果curNext非空的话。
 * 但是Q117是一般二叉树，我们并不知道curNext是否有左子节点或者右子节点。因此使用nextCur记录下一行，已经处理的最后一个节点。
 * 此时，如果cur有左节点，那么nextCur的next指针指向左节点，并且nextCur变成nextCur的next，表明又处理了一个节点。
 * 对于最后一行的判断，必然是curNext为空，同时nextCur也为空，因为nextCur代表下一行已经处理的最后一个节点。
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
