package easy;
/*
 * 2016.5.7
 * 思路和Q26一样，利用冒泡的想法。
 * 还有一种思考方式，因为和Q26不同的是，这个数组是无序的。因此可以通过从数组的末端找到第一个不等于val的元素，然后和当前等于val的元素交换。
 */
public class Q27 {
	public int removeElement(int[] nums, int val) {
		int du = 0;
		for (int i = 0; i < nums.length - du; i++) {
			if (nums[i] == val) {
				for (int j = i; j < nums.length - du - 1; j++) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
				du++;
				i--;
			}
		}
		return nums.length - du;
	}
}
