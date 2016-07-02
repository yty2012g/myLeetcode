package easy;

import java.util.*;

/*
 * 2016.7.2
 * ������ǡ�
 * ��һ����{1}
 * �Ժ�ÿһ�㣬����ǵ�һ��Ԫ�ػ������һ��Ԫ�ؾ���1������Ļ�����i��Ԫ�ؾ�����һ��ĵ�i��Ԫ�غ͵�i-1��Ԫ�صĺ͡�
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
