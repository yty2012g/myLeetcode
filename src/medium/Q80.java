package medium;

/*
 * 2016.5.16
 * 使用cur指向当前能够放的位置，times记录已经重复的次数
 * 如果当前数字等于前一个数字，并且重复的字数小于2，则将数字放到cur位置，重复次数+1，cur向右移动一位。
 * 如果当前数字不等于前一个数字，重复次数记为1，将数字放到cur位置，cur向右移动一位。
 */
public class Q80 {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int cur = 1;
		int times = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] && times < 2) {
				nums[cur] = nums[i];
				cur++;
				times++;
				continue;
			}
			if (nums[i] != nums[i - 1]) {
				times = 1;
				nums[cur] = nums[i];
				cur++;
				continue;
			}
		}
		return cur;
	}
}
