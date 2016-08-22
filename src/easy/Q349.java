package easy;

import java.util.*;

/*
 * 2016.8.22
 * 两种方法，第一种，把nums1变成一个hashset，然后检查nums2的每一个元素。
 * 第二种，将nums1排序，然后使用Arrays.binarySearch来查找nums2的每一个元素。
 * 第一种7ms，第二种，6ms。
 */
public class Q349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length < nums2.length) {
			return intersection(nums2, nums1);
		}
		Arrays.sort(nums1);
		HashSet<Integer> list = new HashSet<Integer>(nums2.length);
		for (int i : nums2) {
			if (Arrays.binarySearch(nums1, i) >= 0)
				list.add(i);
		}
		int[] res = new int[list.size()];
		int count = 0;
		for (Integer i : list) {
			res[count++] = i;
		}
		return res;
	}
}
