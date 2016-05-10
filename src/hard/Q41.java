package hard;

/*
 * 2015.5.10
 * ���͵��뷨���ѣ�ʵ�ֺܼ򵥵���Ŀ
 * ���������ܼ򵥣�ͨ�������ķ�ʽ��ʹ�õ�i��Ԫ�ص�ֵ��i+1����Ҫ��Ҫ���ǵ���ʲô�������Ҫ����
 * ��һ����ǰԪ������������Ϊ��ĿҪ���ҵ���һ���Ǹ���������������û�����塣
 * �ڶ�����ǰԪ�ز������������������i��Ԫ�ص�ֵ��i+1��
 * ���������Ԫ�ص���ȷλ�ò��ܳ����±�
 * ���ģ���ǰԪ�غ���ȷλ�õ�Ԫ�ز���ȣ�����Ϊ�˽���ظ�Ԫ�ص����⡣
 * Ȼ�����ÿһ��Ԫ�أ�����4������������ֱ����һ�����������㣬��ǰԪ�ؾʹ�������ˡ�
 */
public class Q41 {
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] != i + 1 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return nums.length + 1;
	}
}
