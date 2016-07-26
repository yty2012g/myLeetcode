package medium;

/*
 * 2016.7.26
 * 这个似乎想法很简单。
 * 首先数组包含[0..n]中的n个数字。
 * 使用res记录数组中所有数字异或后的结果。
 * 使用flag记录[0...n]这n+1个数字的异或结果。
 * res^flag就是最后的结果。
 * 因为除了那个没出现的数字只出现了一次，其余数字都出现了两次，异或后结果为0；
 */
public class Q268 {
	public int missingNumber(int[] nums) {
		int res = 0;
		int flag = 0;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ nums[i];
			flag = flag ^ (i + 1);
		}
		return res ^ flag;
	}
}
