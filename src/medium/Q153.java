package medium;

/*
 * 2016.7.6
 * �����Ŀ�ܼ򵥣���ͷ��ʼ������������ֵ�ǰԪ�ر���һ��Ԫ�ش�����һ��Ԫ�ؾ�����С��Ԫ�ء�
 * ���û�г�������������˵����С��Ԫ�ؾ��ǵ�һ��Ԫ�ء�
 */
public class Q153 {
	public int findMin(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return nums[i + 1];
		}
		return nums[0];

	}
}
