package hard;

import java.util.*;

/*
 * 2016.7.22
 * 这里利用了双端队列的数据结构。
 * 首先利用一个双端队列保存，滑动窗口中按照值大小排列的下标。
 * 对于第x个数字，如果他比滑动窗口末尾的数字大，那么就把末尾的数字剔除，直到他比末尾的数字小时，加入队列。
 * 为什么剔除呢，因为首先队列的数字出现比x早，但是却比x小，此时即使滑动窗口，淘汰的也只会是这些数字不会是x，所以这些数字就没有用了。
 * 如果此时可以构建滑动窗口，即i>=k-1，如果双端队列的队头的元素为失效，则res[i]就是队头的元素，如果失效了，则剔除，再次比较，直到队头元素有效位置。
 *            
 */
public class Q239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0)
			return nums;
		int[] res = new int[nums.length - k + 1];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < k - 1; i++) {
			while (list.size() > 0 && nums[i] >= nums[list.get(list.size() - 1)]) {
				list.remove(list.size() - 1);
			}
			list.add(i);
		}
		for (int i = k - 1; i < nums.length; i++) {
			while (list.size() > 0 && nums[i] >= nums[list.get(list.size() - 1)]) {
				list.remove(list.size() - 1);
			}
			list.add(i);
			while (i - list.get(0) + 1 > k) {
				list.removeFirst();
			}
			res[i - k + 1] = nums[list.get(0)];
		}
		return res;
	}
}
