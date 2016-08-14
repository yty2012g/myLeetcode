package medium;

/*
 * 2016.8.14
 * �����ʵ����ˮ�ز�������Щ���Ƶģ��ؼ��Եĵط����ڣ���α�֤ÿ��Ԫ�ر�ѡ���ĸ�����1/n
 * ��ˮ�ز���������ȷ��һ��k�ķ�Χ��Ȼ���i=k+1��ʼ������ÿ�μ���random[0,i]�� �����Χ����k�ڣ��Ͱ������λ��ָ���Ԫ�غ�i������
 * ��������⣬��i=1��ʼ������ÿ��ȡrandom[0,len-1]�������[0,i]֮�䣬�򽻻������򲻱䡣ȷ��ÿ��Ԫ�ر����ʵĸ���Ϊ1/n
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
