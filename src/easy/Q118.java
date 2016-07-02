package easy;

import java.util.*;

/*
 * 2016.7.2
 * 杨辉三角。
 * 第一层是{1}
 * 以后每一层，如果是第一个元素或者最后一个元素就是1，否则的话，第i个元素就是上一层的第i个元素和第i-1个元素的和。
 */
public class Q118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return res;
		for (int i = 1; i <= numRows; i++) {
			if (i == 1) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(1);
				res.add(temp);
				continue;
			}
			ArrayList<Integer> temp = (ArrayList<Integer>) res.get(i - 2);
			ArrayList<Integer> t = new ArrayList<Integer>();
			for (int j = 0; j < i; j++) {
				if (j == 0 || j == i - 1) {
					t.add(1);
					if (j == i - 1) {
						res.add(t);
					}
				} else {
					t.add(temp.get(j) + temp.get(j - 1));
				}
			}
		}
		return res;
	}
}
