package easy;

import java.util.*;

/*
 * 2016.8.22
 * ��Ŀ�о��ܼ򵥡�
 * ���Ȱ�nums1��ÿ�����ֱ�����hashmap�С�
 * Ȼ���nums2��ÿ��������hashmap�в��ң�������ҵ�������ʣ�������Ϊ0�Ļ�������ӵ������б���������ִ�����1.
 */
public class Q350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length < nums2.length)
			return intersect(nums2, nums1);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums1.length);
		for (int i : nums1) {
			Integer it = map.get(i);
			if (it == null)
				map.put(i, 1);
			else
				map.put(i, it + 1);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : nums2) {
			Integer it = map.get(i);
			if (it != null && !it.equals(0)) {
				map.put(i, it - 1);
				list.add(i);
			}
		}
		int[] res = new int[list.size()];
		int count = 0;
		for (Integer i : list) {
			res[count++] = i;
		}
		return res;
	}
}
