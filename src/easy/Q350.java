package easy;

import java.util.*;

/*
 * 2016.8.22
 * 题目感觉很简单。
 * 首先把nums1的每个数字遍历到hashmap中。
 * 然后把nums2的每个数字在hashmap中查找，如果能找到，并且剩余次数不为0的话，就添加到最终列表，并且其出现次数减1.
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
