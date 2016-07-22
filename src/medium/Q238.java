package medium;

/*
 * 2016.7.22
 * 超级巧妙地方法。
 * 由于有两个限制条件，第一，O（n）时间复杂度。第二，不能用除法
 * 使用两个额外的数组，dp1[i]表示[0...i-1]所有项的乘积。dp2[i]表示[i+1...n-1]所有项的乘积。
 * res[i]表示最终的乘积，就是用dp1[i]乘以dp2[i]。这里其实用到了动态规划的思想。
 */
public class Q238 {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		int[] res = new int[n];
		dp1[0] = 1;
		dp2[n - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			dp1[i] = dp1[i - 1] * nums[i - 1];
			dp2[n - 1 - i] = dp2[n - 1 - i + 1] * nums[n - 1 - i + 1];
		}
		for (int i = 0; i < nums.length; i++) {
			res[i] = dp1[i] * dp2[i];
		}
		return res;
	}
}
