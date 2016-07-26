package hard;

/*
 * 2016.7.26
 * 这个方法太巧妙了。
 * 首先，nums数组有N+1个数字，包含1到N个数字。所以nums[0]！=0
 * 其次，设计一个递推公式。n(k+1)=f[n(k)],也就是通过第k个数字作为第k+1个数字的下标找到第k+1个数字。
 * 最后，如果出现重复数字，必然有环。
 * 因为通过递推公式可以形成若干链表。如果没有重复数字，那么一定会出现下标越界的情况。
 * 最后找到环即可。
 */
public class Q287 {
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		// 找到快慢指针相遇的地方
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		int find = 0;
		// 用一个新指针从头开始，直到和慢指针相遇
		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}
}
