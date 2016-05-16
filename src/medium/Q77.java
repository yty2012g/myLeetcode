package medium;

import java.util.*;

/*
 * 2016.5.16
 * 使用回溯法，每次增加一个数字，配合一定的剪枝条件。
 * 条件1：如果now的长度等于k直接记录在结果。
 * 条件2，每次测试的数据是从cur开始，最后的数字位于n-prev+1的位置，所以只用遍历到那个位置即可。
 */
public class Q77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		gen(res, 1, n, k, new ArrayList<Integer>());
		System.out.println(res);
		return res;
	}

	public void gen(List<List<Integer>> res, int cur, int n, int k, ArrayList<Integer> now) {
		if (k - now.size() == 0) {
			res.add(now);
			return;
		}
		int prev = k - now.size();
		if (n - prev + 1 < cur)
			return;
		for (int i = cur; i <= n - prev + 1; i++) {
			@SuppressWarnings("unchecked")
			ArrayList<Integer> copy = (ArrayList<Integer>) now.clone();
			copy.add(i);
			gen(res, i + 1, n, k, copy);
		}
	}
}
