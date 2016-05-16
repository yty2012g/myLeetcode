package medium;

import java.util.*;

/*
 * 2016.5.16
 * ʹ�û��ݷ���ÿ������һ�����֣����һ���ļ�֦������
 * ����1�����now�ĳ��ȵ���kֱ�Ӽ�¼�ڽ����
 * ����2��ÿ�β��Ե������Ǵ�cur��ʼ����������λ��n-prev+1��λ�ã�����ֻ�ñ������Ǹ�λ�ü��ɡ�
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
