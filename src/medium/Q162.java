package medium;

/*
 * 2016.7.6
 * �����Ŀ���Ǻ���ȷ�ģ�����û�и㶨ʱ�临�Ӷ�ΪO(lgN)�ķ��������˸о�Ӧ����Ҫ�ö���������
 * Ŀǰ���������Ǳ�������Ԫ�أ��ҵ�����Ҫ���Ԫ�ء�
 * ��ʵ���ö�������Ҳ��һ���ܱ�֤����O(lgN)�ڣ�Ӧ����ƽ��ʱ�临�Ӷȡ�
 */
public class Q162 {
	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] > nums[i + 1])
					return i;
			} else if (i == nums.length - 1) {
				if (nums[i] > nums[i - 1])
					return i;
			} else {
				if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
					return i;
			}
		}
		return 0;
	}
}
