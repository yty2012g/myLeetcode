package easy;

/*
 * 2016.7.8
 * 题目很简单。
 * 注意点，k一定是小于nums.length的，所以先要进行取模操作。如果等于0，就不用移动了。
 * 使用一个新的num数组记录移动后的数据
 * 移动数据。
 * 把num的数据再拷贝回原来的数组nums即可。
 */
public class Q189 {
	public void rotate(int[] nums, int k) {
		int[] num = new int[nums.length];
		k = k % nums.length;
		if (k == 0)
			return;
		for (int i = 0; i < nums.length; i++) {
			num[(i + k) % nums.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = num[i];
		}
	}
}
