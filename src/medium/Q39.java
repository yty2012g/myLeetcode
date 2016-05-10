package medium;

import java.util.*;
/*
 * 2016.5.9
 * Ҫ��1��������Ҫ���ǲ��ظ��Ľ��������Ҫ��hashset��֤���ظ�
 * Ҫ��2��candidatesһ��Ҫ�Ƿǽ����,������ǰ���ȵ���sort����candidates����
 * Ҫ��3��ÿһ��������ҲҪ���򣬷������ڿ����ظ�ʹ�õĹ�ϵ�ᵼ����ͬ�Ľ������˳��ͬ����˲�ͬ�Ľ��
 * �������Ǻܼ򵥣�find���ĸ���������һ���������еĿ���ѡ������֣��ڶ�������Ŀǰ�Ѿ�ѡ�������
 * ����������Ŀǰ���ܺͣ����ĸ�����Ŀ�ꡣ
 */
public class Q39 {
	HashSet<ArrayList<Integer>> hashset = new HashSet<ArrayList<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		ArrayList<Integer> array = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < candidates.length; i++) {
			if (!set.contains(candidates[i])) {
				array.add(candidates[i]);
				set.add(candidates[i]);
			}
		}
		ArrayList<Integer> cur=new ArrayList<Integer>();
		find(array,cur,0,target);
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		Iterator iter=hashset.iterator();
		while(iter.hasNext()){
			res.add((List<Integer>) iter.next());
		}
		return res;
	}

	public void find(ArrayList<Integer> source, ArrayList<Integer> cur, int cursum, int sum) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		if (sum - cursum < source.get(0))
			return;
		for (int i = 0; i < source.size(); i++) {
			if (source.get(i) > sum - cursum)
				break;
			else {
				c = (ArrayList<Integer>) cur.clone();
				cursum = cursum + source.get(i);
				c.add(source.get(i));
				if (cursum == sum) {
					Collections.sort(c);
					hashset.add(c);
					break;
				} else {
					find(source, c, cursum, sum);
				}
			}
			cursum = cursum - source.get(i);
		}
	}
}
