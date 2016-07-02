package easy;

import java.util.*;
/*
 * 2016.7.2
 * 还是用的Q118的方法，没有找到什么好方法来计算组合数。
 */
public class Q119 {
	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i <= rowIndex; i++) {
			if (i == 0) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(1);
				res.add(temp);
				continue;
			}
			ArrayList<Integer> temp = (ArrayList<Integer>) res.get(i - 1);
			ArrayList<Integer> t = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					t.add(1);
					if (j == i) {
						res.add(t);
					}
				} else {
					t.add(temp.get(j) + temp.get(j - 1));
				}
			}
		}
		return res.get(rowIndex);
	}
}
