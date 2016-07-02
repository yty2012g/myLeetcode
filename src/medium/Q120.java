package medium;

import java.util.*;

/*
 * 2016.7.2
 * 这个和杨辉三角是类似的。利用动态规划的方法。
 * 对于第i行的每一格，除了第一格和最后一格只能从上一行的第一格或者最后一个走到。
 * 第j格，可以从第i-1行的第j格走到或者第j-1格走到，因此选择代价较小的那一个即可。
 */
public class Q120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(triangle.get(0).get(0));
		res.add(first);
		int min = 0;
		for (int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			ArrayList<Integer> prev = (ArrayList<Integer>) res.get(i - 1);
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					cur.add(prev.get(0) + triangle.get(i).get(0));
				} else if (j == i) {
					cur.add(prev.get(i - 1) + triangle.get(i).get(i));
				} else {
					cur.add(Math.min(prev.get(j), prev.get(j - 1)) + triangle.get(i).get(j));
				}
			}
			res.add(cur);
			if (i == triangle.size() - 1) {
				min = cur.get(0);
				for (int j = 1; j < cur.size(); j++) {
					if (cur.get(j) < min)
						min = cur.get(j);
				}
			}
		}
		return min;
	}
}
