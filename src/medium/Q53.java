package medium;

/*
 * 2016.5.14
 * ���������������⡣
 * ʹ�ö�̬�滮�����dp����Ϊdp[i] = nums[i] > dp[i - 1] + nums[i] ? nums[i] : dp[i - 1] + nums[i];
 * �����i���������Ե�i-1����Ϊ��β�ĺ�����������ĺͣ���ô�Ե�i������Ϊ��β�ĺ�������������ǵ�i��������
 * ������ǽ���i���������Ե�i-1����Ϊ��β�ĺ��������������
 * ʹ��max������¼���ĺ͡�
 */
public class Q53 {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		int max = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i] > dp[i - 1] + nums[i] ? nums[i] : dp[i - 1] + nums[i];
			max = max > dp[i] ? max : dp[i];
		}
		return max;
	}
}
