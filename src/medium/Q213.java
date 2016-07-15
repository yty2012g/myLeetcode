package medium;

/*
 * 2016.7.15
 * ��Q198���ƣ���ͬ���ǣ�����ķ����ǻ��νṹ��Ҳ���ǵ�һ�������һ������ͬʱ����
 * ����ֳ����������
 * ���1������0�䷿�ӣ���ô��1�䷿�Ӳ�������dp[2]=dp[0]+nums[2]��Ȼ��������һ�����ӣ�dp��ʽΪ
 *        dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]))��
 *        ���һ�䷿�Ӳ�����������dp[nums.length-1] = Math.max(dp[i - 1], dp[i - 2]);
 * ���2��������0�䷿�ӡ�����dp[1]=nums[1]�����ǵ�1�䷿�ӿ�����Ҳ���Բ���������dp[2]=Math.max(dp[1], nums[2]);
 *        Ȼ��ʣ�µķ��Ӷ������������dp��ʽ�����㡣
 * ������������У�����ϴ����һ����
 */
public class Q213 {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		if (nums.length == 3)
			return Math.max(nums[0], Math.max(nums[1], nums[2]));
		if (nums.length == 4)
			return Math.max(nums[0] + nums[2], nums[1] + nums[3]);
		int[] dp = new int[nums.length];
		int max = 0;
		dp[0] = nums[0];
		dp[1] = dp[0];
		dp[2] = dp[1] + nums[2];
		for (int i = 3; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]));
			if (i == nums.length - 1) {
				dp[i] = Math.max(dp[i - 1], dp[i - 2]);
			}
		}
		max = Math.max(max, dp[nums.length - 1]);
		dp = new int[nums.length];
		dp[0] = 0;
		dp[1] = nums[1];
		dp[2] = Math.max(dp[1], nums[2]);
		for (int i = 3; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]));
		}
		max = Math.max(max, dp[nums.length - 1]);
		return max;
	}
}
