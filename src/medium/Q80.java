package medium;

/*
 * 2016.5.16
 * ʹ��curָ��ǰ�ܹ��ŵ�λ�ã�times��¼�Ѿ��ظ��Ĵ���
 * �����ǰ���ֵ���ǰһ�����֣������ظ�������С��2�������ַŵ�curλ�ã��ظ�����+1��cur�����ƶ�һλ��
 * �����ǰ���ֲ�����ǰһ�����֣��ظ�������Ϊ1�������ַŵ�curλ�ã�cur�����ƶ�һλ��
 */
public class Q80 {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int cur = 1;
		int times = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] && times < 2) {
				nums[cur] = nums[i];
				cur++;
				times++;
				continue;
			}
			if (nums[i] != nums[i - 1]) {
				times = 1;
				nums[cur] = nums[i];
				cur++;
				continue;
			}
		}
		return cur;
	}
}
