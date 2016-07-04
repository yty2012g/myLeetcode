package medium;

import java.util.*;

/*
 * 2016.7.4
 * 这个题目非常巧妙。
 * 最笨的方法是这样，首先得到每一个节点的gas和cost之差。根据贪心算法，我优先选择差值最大的那个点开始，模型行车
 * 如果这个点不能通过，则换差值第二大的那个点。由于使用TreeMap将差值进行了排序。所以依次遍历TreeMap即可。
 * 但是上面这个方案，大数据通不过。
 * 
 * 较为巧妙地方法是这样的，由于只存在一种可行的路径，并且一开始汽车是没有油的。
 * 所以找到这样的一个连续序列，序列中每个节点的gas和cost之差记为cur，该序列中所有cur之和为正。找到最长的这样的序列。
 * 以这个序列为起点。如果这个起点都不行，那么其他点就更不行了。
 * 仿照最长连续子序列这个问题的做法，利用动态规划来做。但是公路是环形的。
 * 因此最后选择要么是最长连续子序列，此时路径是否是环形的不影响。
 * 要么就是最短子序列的下一个节点，此时最长路径被分割。
 */
public class Q134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0 || gas.length != cost.length)
			return -1;
		int MAX = gas[0] - cost[0];
		int max = gas[0] - cost[0];
		int MIN = MAX;
		int min = max;
		int stMAX = 0;
		int stmax = 0;
		int endMin = 0;
		int cur = 0;
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			cur = gas[i] - cost[i];
			total += cur;
			if (max < 0) {
				max = cur;
				stmax = i;
			} else
				max += cur;
			if (max > MAX) {
				MAX = max;
				stMAX = stmax;
			}
			if (min > 0)
				min = cur;
			else
				min += cur;
			if (min < MIN) {
				MIN = min;
				endMin = i;
			}
		}
		return total < 0 ? -1 : (MAX >= total - MIN ? stMAX : (endMin + 1) % gas.length);
	}

	// public int canCompleteCircuit2(int[] gas, int[] cost) {
	// TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
	// for (int i = 0; i < gas.length; i++) {
	// treemap.put(i, gas[i] - cost[i]);
	// }
	// Iterator iter = treemap.entrySet().iterator();
	// int res = -1;
	// while (iter.hasNext()) {
	// Map.Entry entry = (Map.Entry) iter.next();
	// int key = (int) entry.getKey();
	// res = start(key, gas, cost);
	// if (res != -1)
	// break;
	// }
	// return res;
	// }
	//
	// public int start(int i, int[] gas, int[] cost) {
	// int next = i % gas.length;
	// int cur = 0;
	// int count = 0;
	// while (cur >= 0) {
	// cur = cur + gas[next] - cost[next];
	// if (cur < 0)
	// break;
	// next = (next + 1) % gas.length;
	// count++;
	// if (count == gas.length)
	// break;
	// }
	// if (count == gas.length)
	// return i;
	// else
	// return -1;
	// }
	//
	// public int maxUp(int[] cur) {
	// int[] dp = new int[cur.length];
	// int sStart = 0;
	// int maxStart = 0;
	// int total = cur[0];
	// int max = 0;
	// int maxnode = 0;
	// dp[0] = cur[0] >= 0 ? cur[0] : 0;
	// for (int i = 1; i < cur.length; i++) {
	// total += cur[i];
	// if (cur[i] < 0)
	// dp[i] = 0;
	// else {
	// if (cur[i] >= cur[i - 1])
	// dp[i] = dp[i - 1] + cur[i];
	// else
	// dp[i] = cur[i];
	// }
	// if (dp[i] > max) {
	// max = dp[i];
	// maxnode = i;
	// }
	// }
	// if (total < 0)
	// return -1;
	// if (cur[0] >= cur[cur.length - 1] && dp[cur.length - 1] > 0) {
	// dp[0] = dp[cur.length - 1]++;
	// for (int i = 1; i < cur.length; i++) {
	// if (dp[i] <= 1)
	// break;
	// else {
	// dp[i] = dp[i - 1] + 1;
	// if (dp[i] > max) {
	// max = dp[i];
	// maxnode = i;
	// }
	// }
	// }
	// }
	// int res = maxnode - max + 1 >= 0 ? maxnode - max + 1 : maxnode - max + 1
	// + cur.length;
	// return res;
	// }
}
