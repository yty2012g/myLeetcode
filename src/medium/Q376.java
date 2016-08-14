package medium;

/*
 * 2016.8.13
 * 两种方法，第一种是基于贪心算法，时间复杂度为O(N)。
 * 一个完整的序列，是由若干个相邻的长度为2的子数组构成的。
 * 因此使用flag作为上一个子序列是升序还是降序的标记。每次判断一组相邻的子序列，根据前面的标记和当前的大小情况确定是否输入序列的一部分。
 * *********************************为什么一定是相邻的长度为2的子数组构成的呢？******************************
 * 假设构成所有子序列的元素都是不相邻的，对于a[i]和a[j]，其中j大于i+1，不妨假设之前是递增的。
 * 那么对于i和j中间的元素,假设为a[k]，如果a[k]大于a[i]，那么，可以将a[i]和a[k]替换上一组递增序列，整个结果保持不变。
 * 如果a[k]等于a[i]，则可以由a[k]代替上一组递增序列，同时下一组依旧是递减序列，结果保持不变。
 * 如果a[k]小于a[i],大于a[j],那么下一组递减序列就会替换为a[i]和a[k]。
 * 如果a[k]小于a[j],那么，下一组的递增序列就会替换为a[k]和a[j]。
 * 综上，完整结果一定是由若干个相邻的子数组构成的。
 * 
 * 
 * ----------------------第二个方法------------------------
 * 使用dp的方法，由于不知道子序列的第一个差值是负数还是正数
 * 因此使用两个dp数组来分别记录正数和负数的情况。
 * dp[i]表示[0..i]，抖动子序列的最大长度。可以根据长度来判断之前是升还是降。
 * 假设第一个差值是正数，
 * 那么如果对于一个元素i而言，dp[i]=max{max[dp[j]+1&&dp[j]是奇数 && nums[i]>nums[j]],max[dp[j]+1&&dp[j]是偶数 && nums[i]<nums[j]]}
 * 所以，需要O(N^2)的时间复杂度。
 * 
 */
public class Q376 {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		Boolean flag = null;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1] && (flag == null || !flag)) {
				flag = true;
				count++;
			} else if (nums[i] < nums[i - 1] && (flag == null || flag)) {
				flag = false;
				count++;
			}
		}
		return count;
	}

	public int wiggleMaxLength2(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int[] dp = new int[nums.length];
		int[] dp2 = new int[nums.length];
		dp[0] = 1;
		dp2[0] = 1;
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			dp2[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j] && (dp[j] & 1) == 1) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} else if (nums[i] < nums[j] && (dp[j] & 1) == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				if (nums[i] < nums[j] && (dp2[j] & 1) == 1) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				} else if (nums[i] > nums[j] && (dp2[j] & 1) == 0) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
			max = Math.max(max, dp2[i]);
		}
		return max;
	}
}
