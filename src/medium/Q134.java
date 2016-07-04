package medium;

import java.util.*;

/*
 * 2016.7.4
 * �����Ŀ�ǳ����
 * ��ķ��������������ȵõ�ÿһ���ڵ��gas��cost֮�����̰���㷨��������ѡ���ֵ�����Ǹ��㿪ʼ��ģ���г�
 * �������㲻��ͨ�����򻻲�ֵ�ڶ�����Ǹ��㡣����ʹ��TreeMap����ֵ�����������������α���TreeMap���ɡ�
 * �����������������������ͨ������
 * 
 * ��Ϊ����ط����������ģ�����ֻ����һ�ֿ��е�·��������һ��ʼ������û���͵ġ�
 * �����ҵ�������һ���������У�������ÿ���ڵ��gas��cost֮���Ϊcur��������������cur֮��Ϊ�����ҵ�������������С�
 * ���������Ϊ��㡣��������㶼���У���ô������͸������ˡ�
 * ��������������������������������ö�̬�滮���������ǹ�·�ǻ��εġ�
 * ������ѡ��Ҫô������������У���ʱ·���Ƿ��ǻ��εĲ�Ӱ�졣
 * Ҫô������������е���һ���ڵ㣬��ʱ�·�����ָ
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
