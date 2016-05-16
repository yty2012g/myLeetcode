package extend;

import java.util.*;

/*
 * 2016.5.16
 * �����ǣ���һ������ֳ����ݣ�Ҫ��������ĺ͵Ĳ�ֵ��С��
 * ����ʹ�ö�̬�滮�ķ�����ת����һ�����Ƶ�0-1�������⡣��¼������ܺ�Ϊsum����Ӧ�������⣬������������
 * �б��Ϊ1��n��n����Ʒ����֪��Ʒ�����������ڸ����İ�������k����ʹ����ʣ��ռ���С����Ʒ��ϡ�
 * ��0-1�������ⲻͬ���ǣ�������������Ʒ�������ͼ�ֵ�������ԣ����ģ������Ʒֻ�����������ԡ�
 * ��̬�滮�������£�
 * 1.�����i-1����Ʒѡ����ʣ��������Ȼ���ڵ�i����Ʒ����������ֱ�ӽ���i����Ʒ���룬ʣ��������ȥ��i����Ʒ��������
 * 2.�����i-1����Ʒѡ����ʣ������С�ڵ�i����Ʒ������������Ŀǰ�ܵı������������ǿյı������ǿ���װ����i����Ʒ
 *   ��Ҫô��װ�����Ʒ��ʣ��ռ�Ϊ��i-1����Ʒѡ���ʣ��������Ҫôװ�����Ʒ����Ҫ�ڳ���i����Ʒ������������i-1����Ʒ������Ϊʣ��ռ����Сʣ��
 *   ����ȡ��С�ġ�
 * 3.����ܵı�������ѹ���Ͳ�����i����Ʒװ����ôֻ��ѡ��װ��i����Ʒ�ˡ�
 *              if (dp[i - 1][j] >= source[i - 1]) {
					dp[i][j] = dp[i - 1][j] - source[i - 1];
				} else if (j >= source[i - 1]) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - source[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
 *  ����·����ѡ�񣬴����һ����Ʒ��ʼ����ѡ�����û��ѡ���i����Ʒ����ô����Ŀǰ����ѡ��i����Ʒ��ѡ��i-1����Ʒ����Сʣ������ȵġ�
 *  �����������ȣ�˵��ѡ���˵�i����Ʒ������i����Ʒ��¼��
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
