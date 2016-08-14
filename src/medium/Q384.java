package medium;

/*
 * 2016.8.14
 * 这个其实和蓄水池采样是有些类似的，关键性的地方在于，如何保证每个元素被选到的概率是1/n
 * 蓄水池采样，首先确定一个k的范围，然后从i=k+1开始遍历，每次计算random[0,i]， 如果范围落在k内，就把随机数位置指向的元素和i交换。
 * 对于这道题，从i=1开始遍历，每次取random[0,len-1]，如果在[0,i]之间，则交换，否则不变。确保每个元素被访问的概率为1/n
 * 
 */
public class Q384 {
	public class Solution {
		public int[] basic;
		public int[] cur;

		public Solution(int[] nums) {
			basic = new int[nums.length];
			cur = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				basic[i] = nums[i];
				cur[i] = nums[i];
			}
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return basic;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			java.util.Random r = new java.util.Random();
			for (int i = 1; i < basic.length; i++) {
				int next = r.nextInt(basic.length);
				if (next < i) {
					int t = cur[next];
					cur[next] = cur[i];
					cur[i] = t;
				}
			}
			return cur;
		}
	}
}
