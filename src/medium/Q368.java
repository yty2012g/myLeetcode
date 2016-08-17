package medium;

import java.util.*;

/*
 * 2016.8.17
 * �����Ŀ����DP��˼�롣�е��������������е�����������O(n^2)����ģ�Ч��һ�㡣
 * ���ȶ������������������γ���һ�����������У�ֻҪ�Ƚϵ�ǰ�������ֵ�Ƿ��ܹ��������Ϳ��Եõ��������С�
 * Ȼ��n[i][]������¼�Ե�i��Ԫ��Ϊ��β�����У�dp[i]�����Ե�i��Ԫ��Ϊ��β�����еĳ��ȡ�
 * ��һ��Ԫ��dpΪ1��nҲֻ������ǰԪ�ء��ӵڶ���Ԫ�ؿ�ʼ������
 * ���ڵ�i��Ԫ�أ���[0]��ʼ�ң��ܱ���i��Ԫ�������ģ��������Ԫ�ء��±��Ϊpos��posλ�õ����г��ȼ�Ϊlen��Ȼ��len++
 * Ȼ��n[i][0...len-2]�Ǵ�posλ�ø��ƹ�����Ȼ��n[i][len-1]�ǵ�i��Ԫ�ء�
 * �����i��Ԫ��֮ǰû���ܹ�������Ԫ�أ���ôֱ��len��Ϊ1��n[i][0]Ϊ��ǰԪ�ؼ��ɡ�
 * �ڱ�������Ԫ��֮ǰ��ʹ��l��¼����Ǹ����еĳ��ȣ�p��¼����е�λ�á�
 * ����������Ԫ�غ󣬽�n[p][0...l-1]��ӵ�list�У����ɡ�
 */
public class Q368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0)
			return res;
		int[][] n = new int[nums.length][nums.length];
		int[] dp = new int[nums.length];
		Arrays.sort(nums);
		int p = 0;
		int l = 1;
		dp[0] = 1;
		n[0][0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int len = 1;
			int pos = i;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[j] > len - 1) {
					pos = j;
					len = dp[i] + 1;
				}
			}
			if (pos == i) {
				n[i][0] = nums[i];
				dp[i] = 1;
			} else {
				for (int j = 0; j < len - 1; j++) {
					n[i][j] = n[pos][j];
				}
				n[i][len - 1] = nums[i];
				dp[i] = len;
			}
			if (dp[i] > l) {
				l = dp[i];
				p = i;
			}
		}
		for (int i = 0; i < l; i++) {
			res.add(n[p][i]);
		}
		return res;
	}
}
