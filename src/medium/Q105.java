package medium;

import basicDataStructure.TreeNode;

/*
 *2016.5.25
 *这个就是根据中序遍历和先序遍历，求出树的结构
 *中序遍历是左中右，先序遍历是中左右。
 *因此先序遍历的第一个元素就是当前树的头节点，由于不存在重复的数字，在中序遍历中找到头节点对应的位置，左半部分是左子树，右半部份是右子树
 *然后递归的生成左右子树即可。 
 */
public class Q105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		if (pe - ps == 0)
			return new TreeNode(preorder[ps]);
		TreeNode root = new TreeNode(preorder[ps]);
		int flag = 0;
		for (int i = is; i <= ie; i++) {
			if (inorder[i] == root.val) {
				flag = i;
				break;
			}
		}
		TreeNode left = null;
		TreeNode right = null;
		if (flag == is) {
			left = null;
		} else {
			left = build(preorder, ps + 1, ps + flag - is, inorder, is, flag - 1);
		}
		if (flag == ie) {
			right = null;
		} else {
			right = build(preorder, ps + flag - is + 1, pe, inorder, flag + 1, ie);
		}
		root.left = left;
		root.right = right;
		return root;
	}
}
