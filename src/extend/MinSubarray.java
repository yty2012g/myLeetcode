package extend;

import java.util.*;

/*
 * 2016.5.16
 * 问题是：将一个数组分成两份，要求子数组的和的差值最小。
 * 这里使用动态规划的方法，转换成一个近似的0-1背包问题。记录数组的总和为sum，对应背包问题，可以如下描述
 * 有编号为1到n的n件物品，已知物品的重量，对于给定的包的容量k，求使包的剩余空间最小的物品组合。
 * 和0-1背包问题不同的是，背包问题中物品有重量和价值两个属性，这个模型中物品只有重量的属性。
 * 动态规划方程如下：
 * 1.如果从i-1件物品选择后的剩余重量依然大于第i件物品的重量，则直接将第i件物品放入，剩余重量减去第i件物品的重量。
 * 2.如果从i-1件物品选择后的剩余重量小于第i件物品的重量，但是目前总的背包容量（就是空的背包）是可以装进第i件物品
 *   则要么不装这件物品，剩余空间为从i-1件物品选择的剩余容量，要么装这件物品，则要腾出第i件物品的重量，看从i-1件物品在重量为剩余空间的最小剩余
 *   两者取较小的。
 * 3.如果总的背包容量压根就不够第i件物品装，那么只能选择不装第i件物品了。
 *              if (dp[i - 1][j] >= source[i - 1]) {
					dp[i][j] = dp[i - 1][j] - source[i - 1];
				} else if (j >= source[i - 1]) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - source[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
 *  对于路径的选择，从最后一件物品开始向上选择，如果没有选择第i件物品，那么对于目前容量选择i件物品和选择i-1件物品的最小剩余是相等的。
 *  所以如果不相等，说明选择了第i件物品，将第i件物品记录。
 */
public class MinSubarray {
	public ArrayList<ArrayList<Integer>> minSub(int[] source) {
		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> two = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < source.length; i++) {
			sum = sum + source[i];
			one.add(source[i]);
		}
		sum = sum / 2;
		// int copy = sum;
		int[][] dp = new int[source.length + 1][sum + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= sum; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= source.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i <= source.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (dp[i - 1][j] >= source[i - 1]) {
					dp[i][j] = dp[i - 1][j] - source[i - 1];
				} else if (j >= source[i - 1]) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - source[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		for (int i = source.length; i > 0; i--) {
			if (dp[i][sum] != dp[i - 1][sum]) {
				one.remove((Integer) source[i - 1]);
				two.add(source[i - 1]);
				sum = sum - source[i - 1];
			}
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		// System.out.println(one);
		// System.out.println(two);
		// System.out.println(dp[source.length][copy]);
		res.add(one);
		res.add(two);
		return res;
	}
}
