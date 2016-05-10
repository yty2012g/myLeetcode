package medium;

import java.util.*;
/*
 * 2016.5.9
 * ������Q39�ǳ����ƣ���ͬ����ÿ��Ԫ��ֻ����ʹ��һ�Ρ�
 * ����q39���ԣ��ظ���Ԫ����û������ģ���Ϊÿ��Ԫ�ؿ����������Σ�������һ��ʼ����ȥ�صĲ���
 * ���Ƕ���q40���ԣ�����ÿ��Ԫ�����ֻ��ʹ��һ�Σ����Բ���Ҫȥ�ء�
 * �ڶ�����Ҫһ��times��ArrayList��������¼�Ǹ�Ԫ�ر�ѡ�ù��ˣ�����ù��ˣ���ֱ��������
 * ����java���ԣ��������ⶼ��Ҫע��ĵ��ǣ�java.util������࣬�������ô��ݣ����Զ���ÿһ�εݹ飬��Ҫ���ǵ�ǰ�޸Ķ�ǰ��ͺ����Ӱ��
 * ���ʹ��һ��clone�Ŀ����汾��
 */
public class Q40 {
	HashSet<ArrayList<Integer>> hashset = new HashSet<ArrayList<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		ArrayList<Integer> array = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < candidates.length; i++) {
			array.add(candidates[i]);
		}
		System.out.println(target);
		ArrayList<Integer> cur = new ArrayList<Integer>();
		ArrayList<Integer> times = new ArrayList<Integer>();
		find(array, cur, times, 0, target);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Iterator iter = hashset.iterator();
		while (iter.hasNext()) {
			res.add((List<Integer>) iter.next());
		}
		return res;
	}

	public void find(ArrayList<Integer> source, ArrayList<Integer> cur, ArrayList<Integer> times, int cursum, int sum) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> t = new ArrayList<Integer>();
		if (sum - cursum < source.get(0))
			return;
		for (int i = 0; i < source.size(); i++) {
			if (source.get(i) > sum - cursum)
				break;
			else if (!times.contains(i)) {
				c = (ArrayList<Integer>) cur.clone();
				t = (ArrayList<Integer>) times.clone();
				t.add(i);
				c.add(source.get(i));
				if (cursum + source.get(i) == sum) {
					Collections.sort(c);
					hashset.add(c);
					break;
				} else {
					find(source, c, t, cursum + source.get(i), sum);
				}
			}

		}
	}
}
