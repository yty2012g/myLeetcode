package easy;

import java.util.*;

/*
 * 2016.7.18
 * 这里使用的是HashMap，key是数字，value是下标。
 * 如果map中没有出现过这个数字则将数字和下标加入map中。
 * 如果map中出现了，如果下标差的绝对值小于k，则返回true；否则将新的下标替换旧的下标。
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
