package medium;

import basicDataStructure.TreeNode;
import java.util.*;

public class Q337 {
	int withRoot = 0;
	int withoutRoot = 0;

	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.val;
		return Math.max(withRoot, withoutRoot);
	}

	public void rob(TreeNode root,LinkedList<Integer> list,boolean flag,int f){
		if(!flag){
			
		}
	}
}
