package medium;

/*
 * 2016.7.14
 * 第一步，计算从第0个数字开始，需要多少个数字能够实现sum大于等于s，子数组长度记录在len，差值记录在cha中。
 * 第二步，对于第i个数字，除去第i-1个数字的差值为cha[i - 1] - nums[i - 1]，如果差值大于0，则长度比len[i-1]少1，差值对应减少
 *         如果差值小于0，那么就从第i-1个数字对应的子数组的末尾的下一个元素开始增加，直到差值大于等于0；
 *         如果加到最后一个数字都无法使差值大于0，则说明从第i个数字之后的所有数字之和都是小于sum的，返回之前的最小长度即可。
 *         如果加到某一位，差值大于0，则记录len和cha，并且比较len和min，取较小的赋值给min
 */
public class Q209 {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] len = new int[nums.length];
		int[] cha = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum >= s) {
				cha[0] = sum - s;
				len[0] = i + 1;
				break;
			}
		}
		if (len[0] == 0)
			return 0;
		int min = len[0];
		for (int i = 1; i < nums.length; i++) {
			int tempSum = cha[i - 1] - nums[i - 1];
			if (tempSum >= 0) {
				len[i] = len[i - 1] - 1;
				min = Math.min(len[i], min);
				cha[i] = tempSum;
			} else {
				if (i + len[i - 1] - 1 < nums.length) {
					for (int j = i + len[i - 1] - 1; j < nums.length; j++) {
						tempSum += nums[j];
						if (tempSum >= 0) {
							len[i] = j - i + 1;
							cha[i] = tempSum;
							break;
						}
					}
					if (tempSum >= 0)
						min = Math.min(len[i], min);
					else
						break;
				} else {
					break;
				}
			}
			if (len[i] == 1 || nums[i] == s)
				return 1;
		}
		return min;
	}
}
