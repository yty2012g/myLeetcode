package easy;

import java.util.*;

/*
 * 2016.8.22
 * ���ַ�������һ�֣���nums1���һ��hashset��Ȼ����nums2��ÿһ��Ԫ�ء�
 * �ڶ��֣���nums1����Ȼ��ʹ��Arrays.binarySearch������nums2��ÿһ��Ԫ�ء�
 * ��һ��7ms���ڶ��֣�6ms��
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
