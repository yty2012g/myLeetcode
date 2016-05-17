package medium;

/*
 * 2016.5.17
 * �򵥵Ķ��������������ҵ��ֽ�㣬Ȼ��Էֽ������߽�������
 * ���ڲ��ܲ��У�����һ�����ȼ��һ�ߣ��ټ����һ�ߡ�
 * һ���򵥵��Ż���֦���ǣ����һ���Ѿ��������н���ˣ���һ�߾�û�б�Ҫ����ˡ�
 */
public class Q81 {
	public boolean search(int[] nums, int target) {
		if (nums.length == 0)
			return false;
		if (nums.length == 1)
			return nums[0] == target ? true : false;
		int num = du(nums);
		int beforestart = 0;
		int beforeend = num - 1;
		int afterstart = num;
		int afterend = nums.length - 1;
		int bres = find(nums, target, beforestart, beforeend);
		if (bres != -1)
			return true;
		int ares = find(nums, target, afterstart, afterend);
		if (ares != -1)
			return true;
		return false;
	}

	public int find(int[] nums, int target, int start, int end) {
		int res = -1;
		while (start <= end) {
			if (nums[(end + start) / 2] == target) {
				return (end + start) / 2;
			} else if (nums[(end + start) / 2] > target) {
				end = (end + start) / 2 - 1;
			} else {
				start = (end + start) / 2 + 1;
			}
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
}
