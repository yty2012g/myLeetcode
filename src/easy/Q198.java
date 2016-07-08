package easy;

/*
 * 2016.7.8
 * ��̬�滮���⡣�����ģ���ǣ���һ���Ǹ������г�ȡһ�����������ڵ����֣�������
 * dp[i]=max(max(dp[i-1],dp[i-2]+nums[i]),dp[i-3])   ��i>=3ʱ��
 * ����dp[i]��ʾ�Ե�iλΪ��β�Ĳ�����Ԫ�ص����͡�
 * ���ѡ����nums[i]֮ǰ���Ϳ�����dp[i-2]Ҳ������dp[i-3]��Ϊʲô�������Ǹ�ǰ���أ���Ϊdp[i-3]֮ǰ�ǿ���ѡ��nums[i-1],��ÿ��Ԫ�ض��ǷǸ���
 * ����֮ǰ���������ֻ�ܵ�dp[i-3].
 * ��Ȼ�����п��ܲ�ѡ��nums[i]����ô֮ǰ�����;���dp[i-1]�ˡ���������ȥmax���ɡ�
 */
public class Q198 {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		if (nums.length == 3) {
			return Math.max(nums[1], nums[0] + nums[2]);
		}
		if (nums.length == 4) {
			return Math.max(nums[0] + nums[3], Math.max(nums[0] + nums[2], nums[1] + nums[3]));
		}
		dp[0] = nums[0];
		dp[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
			if (i >= 3) {
				dp[i] = Math.max(dp[i], dp[i - 3] + nums[i]);
			}
		}
		return dp[nums.length - 1];
	}
}
