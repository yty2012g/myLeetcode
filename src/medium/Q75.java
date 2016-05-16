package medium;

/*
 * 2016.5.16
 * 利用和快排partition一样的策略。
 * 由于颜色的分布是红白蓝，因此只要将红色和蓝色都分好，剩下的就是白色
 * 使用ri记录红色组的下标右边界。
 * 使用bi记录蓝色组的下标左边界。
 * 如果某一位是红色或者蓝色，那么就将这个元素移动到对应的下标边界，同时边界扩展，如果这个元素已经在边界旁边，就不用移动，直接扩展就行。
 */
public class Q75 {
	public void sortColors(int[] nums) {
		int ri = -1;
		int bi = nums.length;
		for (int i = 0; i < bi; i++) {
			while (nums[i] == 0 || nums[i] == 2) {
				if (nums[i] == 0) {
					if (i != ri + 1) {
						int temp = nums[ri + 1];
						nums[ri + 1] = nums[i];
						nums[i] = temp;
						ri++;
					} else {
						ri++;
						break;
					}
				}
				if (nums[i] == 2) {
					if (i != bi - 1) {
						int temp = nums[bi - 1];
						nums[bi - 1] = nums[i];
						nums[i] = temp;
						bi--;
					} else {
						bi--;
						break;
					}
				}
			}
		}
	}
}
