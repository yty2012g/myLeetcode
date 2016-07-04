package medium;

/*
 * 2016.7.4
 * 这个题目，如果简单来说可以使用hashmap这样的数据结构。如果要求O（n）级时间复杂度和常数级空间复杂度，就不能这样做。
 * 这里利用异或的原理，题目说除了一个数字出现1次，其余数字都出现两次，由于a xor a = 0.
 * 将所有数字都异或操作，只有那个出现一次的数字会剩下，其与数字都变成了0。
 */
public class Q136 {
	public int singleNumber(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 0)
			return 0;
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
	}
}
