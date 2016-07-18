package medium;

import java.util.*;

public class Q220 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0)
			return false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j - i <= k && j < nums.length; j++) {
				if (Math.abs((long)nums[i] - (long)nums[j]) <= (long)t)
					return true;
			}
		}
		return false;
	}
}
