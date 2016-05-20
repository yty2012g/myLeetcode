package medium;

import java.util.*;

/*
 * 2016.5.20
 * ����û���û��ݣ�ʹ�õ��Ƕ����Ƶķ�����
 * nums��ÿһ�����ִ���һλ�����ƣ�Ҫô����1��Ҳ���Ǽ���������֣�Ҫô����0��Ҳ���ǲ������������
 * ���Դ�0������2^n-1.�ҵ�ÿһ�����ֶ�Ӧ�Ķ����ƣ�����1�����λ������ʾʹ����Щ���֣�����Щ���ּ��������ɡ�
 */
public class Q90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		HashSet<ArrayList<Integer>> hashset = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
			String temp = Integer.toBinaryString(i);
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = temp.length() - 1; j >= 0; j--) {
				if (temp.charAt(j) == '1') {
					list.add(nums[temp.length() - 1 - j]);
				}
			}
			Collections.sort(list);
			hashset.add(list);
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Iterator iter = hashset.iterator();
		while (iter.hasNext()) {
			res.add((List<Integer>) iter.next());
		}
		return res;
	}

}
