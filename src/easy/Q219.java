package easy;

import java.util.*;

/*
 * 2016.7.18
 * ����ʹ�õ���HashMap��key�����֣�value���±ꡣ
 * ���map��û�г��ֹ�������������ֺ��±����map�С�
 * ���map�г����ˣ�����±��ľ���ֵС��k���򷵻�true�������µ��±��滻�ɵ��±ꡣ
 */
public class Q219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(map.get(nums[i]) - i) <= k)
					return true;
				else
					map.put(nums[i], i);
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
}
