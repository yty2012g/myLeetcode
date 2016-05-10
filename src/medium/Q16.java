package medium;

import java.util.Arrays;

/*
 * 2016.5.4
 * ��3sum�Ƚ����ƣ���һ������
 * �ڶ������̶���һ�����֣�Ȼ�����2sum�ķ�ʽ�ҡ�����ҵ��������ֺ�ǡ�õ���ʣ���target���򷵻�target����
 * �����ҵ���target�Ĳ�ֵ�ľ���ֵ��С����ϣ�ÿ�ι̶��ĵ�һ�����ֿ����ҵ�һ������ֵ��С�Ĳ�ֵ��
 * ������Ҫ�㣬������ʣ��target����������������߱���С��������С����ֱ�ӷ��ز�ֵ���ɡ�
 */
public class Q16 {
	public int threeSumClosest(int[] nums, int target) {
		int min = 0;
		boolean flag = false;
		int len = nums.length;
		int start = 0;
		int end = 0;
		Arrays.sort(nums);
		for (int i = 0; i < len - 2; i++) {
			start = i + 1;
			end = len - 1;
			int smalltarget = target - nums[i];
			int tempmin = 0;
			boolean tempflag = false;
			if (nums[end] + nums[end - 1] < smalltarget) {
				tempmin = nums[end] + nums[end - 1] - smalltarget;
				tempflag = true;
			} else if (nums[start] + nums[start + 1] > smalltarget) {
				tempmin = nums[start] + nums[start + 1] - smalltarget;
				tempflag = true;
			} else {
				while (start < end) {
					if (nums[start] + nums[end] != smalltarget) {
						if (tempflag) {
							tempmin = Math.abs(tempmin) < Math.abs(nums[start] + nums[end] - smalltarget) ? tempmin
									: nums[start] + nums[end] - smalltarget;
						} else {
							tempmin = nums[start] + nums[end] - smalltarget;
							tempflag = true;
						}
						if (nums[start] + nums[end] > smalltarget)
							end--;
						else
							start++;
					} else {
						return target;
					}
				}
			}
			if (flag) {
				min = Math.abs(min) < Math.abs(tempmin) ? min : tempmin;
			} else {
				min = tempmin;
				flag = true;
			}
		}
		return target + min;
	}
}
