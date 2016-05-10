package medium;

/*
 * 2016.5.8
 * Ӧ�����ζ�������
 * ���ڷ�Χ��ͷ�߽���ԣ�ͷ�߽��Ӧ���±�i��һ������nums[i]==target,nums[i-1]<target,��i>0�������
 * ͬ���ģ�β�߽�Ҳ��������nums[i]==target,nums[i+1]>target����i<nums.length-1������¡�
 * ����������ı߽����⣬���i���������ͷ����β�Ĵ�������
 */
public class Q34 {
	public int[] searchRange(int[] nums, int target) {
		int si = findsmall(nums, target);
		int bi = findbig(nums, target);
		int[] res = { si, bi };
		return res;
	}

	public int findsmall(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int num = (start + end) / 2;
			if (nums[num] == target) {
				if (num == 0 || nums[num - 1] < target)
					return num;
				if (nums[num - 1] == target)
					end = num - 1;
				continue;
			}
			if (nums[num] > target) {
				end = num - 1;
			} else {
				start = num + 1;
			}
		}
		return -1;
	}

	public int findbig(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int num = (start + end) / 2;
			if (nums[num] == target) {
				if (num == nums.length - 1 || nums[num + 1] > target)
					return num;
				if (nums[num + 1] == target)
					start = num + 1;
				continue;
			}
			if (nums[num] > target) {
				end = num - 1;
			} else {
				start = num + 1;
			}
		}
		return -1;
	}
}
