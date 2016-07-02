package medium;

import java.util.*;

/*
 * 2016.7.2
 * �����������������Ƶġ����ö�̬�滮�ķ�����
 * ���ڵ�i�е�ÿһ�񣬳��˵�һ������һ��ֻ�ܴ���һ�еĵ�һ��������һ���ߵ���
 * ��j�񣬿��Դӵ�i-1�еĵ�j���ߵ����ߵ�j-1���ߵ������ѡ����۽�С����һ�����ɡ�
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
