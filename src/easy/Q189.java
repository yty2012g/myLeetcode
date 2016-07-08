package easy;

/*
 * 2016.7.8
 * ��Ŀ�ܼ򵥡�
 * ע��㣬kһ����С��nums.length�ģ�������Ҫ����ȡģ�������������0���Ͳ����ƶ��ˡ�
 * ʹ��һ���µ�num�����¼�ƶ��������
 * �ƶ����ݡ�
 * ��num�������ٿ�����ԭ��������nums���ɡ�
 */
public class Q189 {
	public void rotate(int[] nums, int k) {
		int[] num = new int[nums.length];
		k = k % nums.length;
		if (k == 0)
			return;
		for (int i = 0; i < nums.length; i++) {
			num[(i + k) % nums.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = num[i];
		}
	}
}
