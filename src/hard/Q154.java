package hard;

/*
 * 2016.7.6
 * ��Q153һģһ���Ĵ��롣��˼Ҳ��һģһ��������Ϊ�жϵ������ǵ�ǰԪ�ر���һ��Ԫ�ش����Լ�ʹ���ظ�Ҳ�������������
 */
public class Q154 {
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
