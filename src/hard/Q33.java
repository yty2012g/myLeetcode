package hard;
/*
 * 2016.5.8
 * 典型的二分搜索，du方法用来找到反转的点，使用循环从头遍历，找到一个元素比这个元素之前的元素要小，此时就是反转点。
 * 然后根据反转点，将原数组逻辑的分成两个有序数组，然后就是对这两个有序数组应用二分搜索就可以了。
 */
public class Q33 {
	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		if (nums.length == 1)
			return nums[0] == target ? 0 : -1;
		int num = du(nums);
		int beforestart = 0;
		int beforeend = num - 1;
		int afterstart = num;
		int afterend = nums.length - 1;
		int bres = find(nums, target, beforestart, beforeend);
		int ares = find(nums, target, afterstart, afterend);
		return bres == -1 ? (ares == -1 ? -1 : ares) : bres;
	}

	public int find(int[] nums, int target, int start, int end) {
		int res = -1;
		while (start <= end) {
			if (nums[(end + start) / 2] == target)
				return (end + start) / 2;
			else if (nums[(end + start) / 2] > target)
				end = (end + start) / 2 - 1;
			else
				start = (end + start) / 2 + 1;
		}
		return res;
	}

	public int du(int[] nums) {
		int dp = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				dp = i;
				break;
			}
		}
		return dp;
	}

	public void print(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
}