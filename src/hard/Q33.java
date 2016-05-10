package hard;
/*
 * 2016.5.8
 * ���͵Ķ���������du���������ҵ���ת�ĵ㣬ʹ��ѭ����ͷ�������ҵ�һ��Ԫ�ر����Ԫ��֮ǰ��Ԫ��ҪС����ʱ���Ƿ�ת�㡣
 * Ȼ����ݷ�ת�㣬��ԭ�����߼��ķֳ������������飬Ȼ����Ƕ���������������Ӧ�ö��������Ϳ����ˡ�
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