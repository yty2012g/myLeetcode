package easy;

/*
 * 2016.7.26
 * ������������˿���������partition������
 * ʹ��һ��flag��Ϊ���һ����Ϊ0�ı�־����ʼflagΪ-1��
 * �����i��Ԫ�ز�Ϊ0����ô�ͺ�flag�ĺ�һ��Ԫ�ؽ��������flag+1����i����ô�������Ԫ�ز�Ϊ0�����򽻻����Ԫ��Ϊ0��flag++
 */
public class Q283 {
	public void moveZeroes(int[] nums) {
		int flag = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[flag + 1] = nums[i];
				nums[i] = i == flag + 1 ? nums[i] : 0;
				flag++;
			}
		}
	}
}
