package easy;
/*
 * 2016.7.28
 * ����������dp��˼�롣
 * dp[i]������[0..i-1]�ĺ͡�
 * ���������a��b�ĺͣ���Ϊdp[b+1]-dp[a]��
 */
public class Q303 {
	public class NumArray {
		int[] dp;

		public NumArray(int[] nums) {
			dp = new int[nums.length + 1];
			dp[0] = 0;
			for (int i = 1; i <= nums.length; i++) {
				dp[i] = dp[i - 1] + nums[i - 1];
			}
		}

		public int sumRange(int i, int j) {
			return dp[j + 1] - dp[i];
		}
	}
}
