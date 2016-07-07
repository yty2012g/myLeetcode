package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.7
 * �ڹ��캯���У�ʹ���˶������ǵݹ���ʽ������������õ���һ��arraylist��
 * ����BST�������������ǵ����ġ�����ʹ��curָ��ָ����С��Ԫ�ء�
 * hasNext�������ж�cur�Ƿ���list�±��ڡ�
 * next���������ȵõ���Сֵ��cur����ָ����һ����Сֵ��Ȼ�󷵻���Сֵ���ɡ�
 */
public class Q173 {
	public class BSTIterator {
		public ArrayList<Integer> list;
		public int cur;

		public BSTIterator(TreeNode root) {
			this.list = new ArrayList<Integer>();
			this.cur = 0;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode c = root;
			while (c != null || !stack.empty()) {
				if (c != null) {
					stack.push(c);
					c = c.left;
				} else {
					c = stack.pop();
					list.add(c.val);
					c = c.right;
				}
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return cur < list.size();
		}

		/** @return the next smallest number */
		public int next() {
			int res = list.get(cur);
			cur++;
			return res;
		}
	}
}
