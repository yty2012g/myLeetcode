package medium;

import java.util.*;

/*
 * 2016.7.15
 * 就是dfs。
 * 使用一个onStack标记已经记录的数字。然后递归遍历即可。 
 *  
 */
public class Q216 {
	boolean[] onStack = new boolean[9];
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		dfs(k, n, new ArrayList<Integer>());
		return res;
	}

	public void dfs(int k, int n, ArrayList<Integer> prefix) {
		if (k == 0) {
			List<Integer> copy = (List<Integer>) prefix.clone();
			res.add(copy);
			return;
		}
		if ((9 + 9 - k + 1) * k / 2 < n)
			return;
		if (k == 1) {
			if (n <= 9 && !onStack[n - 1] && n > (prefix.size() == 0 ? 1 : prefix.get(prefix.size() - 1))) {
				ArrayList<Integer> copy = (ArrayList<Integer>) prefix.clone();
				copy.add(n);
				dfs(k - 1, 0, copy);
			}
			return;
		}
		for (int i = prefix.size() == 0 ? 1 : prefix.get(prefix.size() - 1) + 1; i <= 9; i++) {
			if (!onStack[i - 1] && n > i) {
				ArrayList<Integer> copy = (ArrayList<Integer>) prefix.clone();
				onStack[i - 1] = true;
				copy.add(i);
				dfs(k - 1, n - i, copy);
				onStack[i - 1] = false;
			}
		}
	}
}
