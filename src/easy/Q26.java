package easy;

/*
 * 2015.5.7
 * 这道题很简单，如果一个元素和它的前一个元素相等，就仿照冒泡排序的方法将这个元素移动到最尾端，同时使用du变量记录重复元素的个数。
 * 需要注意的要点是，如果移动后，i需要减1。因为在移动的过程已经将后面的元素下标全部向前移动一位了，因此需要减一。
 * 最后就是，这道题的限制条件是额外空间复杂度为常量级。如果没有这个限制，直接使用hashmap或者hashset这样的集合类，将所有元素遍历
 * 统计集合的size即可。
 */
public class Q26 {
	public int removeDuplicates(int[] nums) {
		int du = 0;
		if (nums.length == 0 || nums.length == 1)
			return nums.length;
		for (int i = 1; i < nums.length - du; i++) {
			if (nums[i] == nums[i - 1]) {
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
