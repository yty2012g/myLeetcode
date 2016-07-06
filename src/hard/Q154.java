package hard;

/*
 * 2016.7.6
 * 和Q153一模一样的代码。意思也是一模一样。。因为判断的条件是当前元素比下一个元素大，所以即使有重复也不会出发条件。
 */
public class Q154 {
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
