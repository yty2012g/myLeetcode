package medium;

import java.util.HashMap;

public class Q55 {
	HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

	public boolean canJump(int[] nums) {
		return can(nums, 0);
	}

	public boolean can(int[] nums, int index) {
		if (nums[index] == 0)
			return false;
		for (int i = nums[index]; i > 0; i--) {
			if (map.get(index + i) != null && map.get(index + i) == false) {
				continue;
			}
			if (index + i >= nums.length || (map.get(index + i) != null && map.get(index + i) == true)
					|| can(nums, index + i)) {
				map.put(index, true);
				return true;
			}
		}
		map.put(index, false);
		return false;
	}
}
