package hard;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Q45 {
	public int jump(int[] nums) {
		if (nums.length == 1 || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		tmap.put(0, nums.length - 1);
		dp[dp.length - 1] = 0;
		for (int i = dp.length - 2; i >= 0; i--) {
			int max = nums[i] > (dp.length - 1 - i) ? (dp.length - 1 - i) : nums[i];
			Iterator iter = tmap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				if ((Integer) entry.getValue() <= i + max) {
					dp[i]=(Integer) entry.getKey() + 1;
					tmap.put((Integer) entry.getKey() + 1, i);
					break;
				}
			}		
		}
		return dp[0];
	}
}
