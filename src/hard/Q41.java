package hard;

/*
 * 2015.5.10
 * 典型的想法很难，实现很简单的题目
 * 方法描述很简单，通过交换的方式，使得第i个元素的值是i+1，主要需要考虑的是什么情况下需要交换
 * 第一，当前元素是正数，因为题目要求找到第一个非负整数，调整负数没有意义。
 * 第二，当前元素不符合上面的条件（第i个元素的值是i+1）
 * 第三，这个元素的正确位置不能超过下标
 * 第四，当前元素和正确位置的元素不相等，这是为了解决重复元素的问题。
 * 然后对于每一个元素，按照4个条件遍历，直到有一个条件不满足，当前元素就处理完毕了。
 */
public class Q41 {
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] != i + 1 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return nums.length + 1;
	}
}
