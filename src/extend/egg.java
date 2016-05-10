package extend;

import java.util.Iterator;
import java.util.TreeMap;

/*
 * 2016.5.7
 * 第一个方法求解，a个鸡蛋，测试b次，最多能够测试多少层楼
 * 第二个方法求解，a个鸡蛋，测试b层楼，至少需要多少次。
 * 第一个方法，dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] + 1;
 * dp[i][j]表示，i+1个鸡蛋，测试j次。我要保证测试总数为j次，如果第一次测试失败，那么我最多只能测试dp[i-1][j-1]+1层楼
 * 测试的总数还是j次。
 * 如果第一次成功了，那么我还能测试j-1次，如果第二次失败，那么我最多只能测试dp[i-1][j-2]+1层楼。测试的总数为j-1次
 * 以此类推，直到我测试的楼层只为1层。
 * 也就是dp[i-1][j-1]+1+dp[i-1][j-2]+dp[i-1][j-3]+...+1
 * 通过发现，我们可以知道后面的部分等价于i个鸡蛋测试j-1次的楼层数。所以综合的方程为上面的方程。
 * 
 * 第二个方法，dp[i][j]=min{max(dp[i-1][k-1]+1,dp[i][j-k]+1)} k=1...j;表示使用i+1个鸡蛋测试j层楼，至少要用多少次。
 * 由于我们在每一个楼层测试时，并不清楚第一次应该在那一层测试。所以k的那个循环就是计算在1到j层，选择哪一层。
 * 里面的max表示，如果在第k层碎了，那么剩下的k-1层要用i-1个鸡蛋测试完。如果第k层没有碎，那么剩下的j-k层要用i个鸡蛋测试。
 * 由于计算的是最坏情况，所以选取两个中的最大值。
 * 外面的min表示，选择哪一层能让第j层的测试次数最少。
 */
public class egg {
	public int eggAndtime(int eggnum, int times) {
		int[][] dp = new int[eggnum][times];
		for (int i = 0; i < times; i++) {
			dp[0][i] = i + 1;
		}
		for (int i = 0; i < eggnum; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < eggnum; i++) {
			for (int j = 1; j < times; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] + 1;
			}
		}
		print(dp, eggnum, times);
		return dp[eggnum - 1][times - 1];
	}

	public int eggAndLou(int eggnum, int lou) {
		int[][] dp = new int[eggnum][lou + 1];
		for (int i = 0; i <= lou; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i < eggnum; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i < eggnum; i++) {
			for (int j = 1; j <= lou; j++) {
				TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
				for (int k = 1; k <= j; k++) {
					tm.put(Math.max(dp[i - 1][k - 1] + 1, dp[i][j - k] + 1), 1);
				}
				Iterator<Integer> it = tm.keySet().iterator();
				dp[i][j] = (int) it.next();
			}
		}
		//print(dp, eggnum, lou);
		return dp[eggnum-1][lou];
	}

	public void print(int[][] dp, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
