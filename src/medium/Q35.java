package medium;

/*
 * 2016.5.8
 * ���Ƕ���������ֻ�����Ƚ�q34���߽��������Ƹ��Ӷ���
 * һ��Ҫ�ѵ��ڣ����ڣ�С�ڵ������ȫ�ֿ���
 */
public class Q35 {
	public int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int num = (start + end) / 2;
			if (nums[num] == target) {
				if (num == 0 || nums[num - 1] < target)
					return num == 0 ? 0 : num;
				if (nums[num - 1] == target) {
					end = num - 1;
				}
			} else if (nums[num] > target) {
				if (num == 0 || nums[num - 1] < target)
					return num == 0 ? 0 : num;
				else
					end = num - 1;
			} else {
				if (num == nums.length - 1 || nums[num + 1] > target)
					return num == nums.length - 1 ? nums.length : num + 1;
				else
					start = num + 1;
			}
		}
		return 0;
	}
}
