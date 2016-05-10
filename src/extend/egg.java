package extend;

import java.util.Iterator;
import java.util.TreeMap;

/*
 * 2016.5.7
 * ��һ��������⣬a������������b�Σ�����ܹ����Զ��ٲ�¥
 * �ڶ���������⣬a������������b��¥��������Ҫ���ٴΡ�
 * ��һ��������dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] + 1;
 * dp[i][j]��ʾ��i+1������������j�Ρ���Ҫ��֤��������Ϊj�Σ������һ�β���ʧ�ܣ���ô�����ֻ�ܲ���dp[i-1][j-1]+1��¥
 * ���Ե���������j�Ρ�
 * �����һ�γɹ��ˣ���ô�һ��ܲ���j-1�Σ�����ڶ���ʧ�ܣ���ô�����ֻ�ܲ���dp[i-1][j-2]+1��¥�����Ե�����Ϊj-1��
 * �Դ����ƣ�ֱ���Ҳ��Ե�¥��ֻΪ1�㡣
 * Ҳ����dp[i-1][j-1]+1+dp[i-1][j-2]+dp[i-1][j-3]+...+1
 * ͨ�����֣����ǿ���֪������Ĳ��ֵȼ���i����������j-1�ε�¥�����������ۺϵķ���Ϊ����ķ��̡�
 * 
 * �ڶ���������dp[i][j]=min{max(dp[i-1][k-1]+1,dp[i][j-k]+1)} k=1...j;��ʾʹ��i+1����������j��¥������Ҫ�ö��ٴΡ�
 * ����������ÿһ��¥�����ʱ�����������һ��Ӧ������һ����ԡ�����k���Ǹ�ѭ�����Ǽ�����1��j�㣬ѡ����һ�㡣
 * �����max��ʾ������ڵ�k�����ˣ���ôʣ�µ�k-1��Ҫ��i-1�����������ꡣ�����k��û���飬��ôʣ�µ�j-k��Ҫ��i���������ԡ�
 * ���ڼ����������������ѡȡ�����е����ֵ��
 * �����min��ʾ��ѡ����һ�����õ�j��Ĳ��Դ������١�
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
