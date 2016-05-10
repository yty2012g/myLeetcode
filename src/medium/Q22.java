package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 2016.5.5
 * 这道题目就是典型的深度优先搜索，因为每一次可以选择加入左括号或者右括号，构成了一颗二叉树
 * 这里的优化就是配合一定的剪枝：
 * 第一，如果左括号数大于n了，直接返回上一层
 * 第二，只有在待匹配的左括号数大于0时才能放右括号。
 * 递归要点，每次递归深度要加一，如果是左括号，则待匹配的左括号数加一，左括号总数加一，如果是右括号，则待匹配的左括号数减一
 */
public class Q22 {
	public List<String> res;

	public List<String> generateParenthesis(int n) {
		res = new ArrayList<String>();
		solve(0, 2 * n, 0, 0, "");
		return res;
	}

	public void solve(int dep, int maxDep, int leftNum, int leftNumTotal, String s) {
		if (leftNumTotal * 2 > maxDep)
			return;

		if (dep == maxDep) {
			res.add(s);
			return;
		}

		for (int i = 0; i < 2; i++)
			if (i == 0) {
				solve(dep + 1, maxDep, leftNum + 1, leftNumTotal + 1, s + '(');
			} else {
				if (leftNum > 0)
					solve(dep + 1, maxDep, leftNum - 1, leftNumTotal, s + ')');
			}
	}
}
