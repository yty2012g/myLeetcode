package medium;

/*
 * 2016.7.6
 * 这个题目很简单，从头开始遍历，如果出现当前元素比下一个元素大，则下一个元素就是最小的元素。
 * 如果没有出现上面的情况，说明最小的元素就是第一个元素。
 */
public class Q153 {
	public int findMin(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return nums[i + 1];
		}
		return nums[0];

	}
}
