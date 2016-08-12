package medium;

/*
 * 2016.8.12
 * dp[i]��ʾ����Ϊi��ʱ���ж�������ϡ�
 * dp[i]=dp[i-nums[k]]{k=0...k.length-1}
 * �����˼�ǣ�ÿ��ֻȷ�����һ������
 * ���統k����1��ʱ�򣬱�ʾ�����������һ��������1��Ȼ��֮ǰ�ĺ���i-1������ֻҪ֪��֮ǰ�Ĵ�������ô���һλ��1�Ĵ���Ҳ��֪���ˡ�
 * 
 */

public class Q377 {
	public int combinationSum4(int[] nums, int target) {
		int dp[] = new int[target + 1];
		for (int i = 0; i <= target; i++) {
			for (int k = 0; k < nums.length; k++) {
				if (i - nums[k] > 0) {
					dp[i] += dp[i - nums[k]];
				} else if (i - nums[k] == 0) {
					dp[i] += 1;
				}

			}
		}
		return dp[target];
	}
}
