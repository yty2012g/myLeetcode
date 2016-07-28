package medium;

/*
 * 2016.7.28
 * ��׼dp������
 * ʱ�临�Ӷ�nƽ����
 * ʹ�ö��������ķ�����ʵ�ڲ������ˡ�
 * 
 */
public class Q300 {
	public int N2lengthOfLIS(int[] nums) {
		int max = 0;
		if (nums.length == 0)
			return max;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		max = 1;
		for (int i = 1; i < nums.length; i++) {
			int maxL = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					maxL = Math.max(maxL, dp[j]);
				}
			}
			dp[i] = maxL + 1;
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
