package easy;

/*
 * 2016.7.26
 * 这个就是利用了快速排序中partition方法。
 * 使用一个flag作为最后一个不为0的标志。初始flag为-1；
 * 如果第i个元素不为0，那么就和flag的后一个元素交换。如果flag+1就是i，那么交换后的元素不为0，否则交换后的元素为0，flag++
 */
public class Q283 {
	public void moveZeroes(int[] nums) {
		int flag = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[flag + 1] = nums[i];
				nums[i] = i == flag + 1 ? nums[i] : 0;
				flag++;
			}
		}
	}
}
