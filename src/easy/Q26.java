package easy;

/*
 * 2015.5.7
 * �����ܼ򵥣����һ��Ԫ�غ�����ǰһ��Ԫ����ȣ��ͷ���ð������ķ��������Ԫ���ƶ�����β�ˣ�ͬʱʹ��du������¼�ظ�Ԫ�صĸ�����
 * ��Ҫע���Ҫ���ǣ�����ƶ���i��Ҫ��1����Ϊ���ƶ��Ĺ����Ѿ��������Ԫ���±�ȫ����ǰ�ƶ�һλ�ˣ������Ҫ��һ��
 * �����ǣ����������������Ƕ���ռ临�Ӷ�Ϊ�����������û��������ƣ�ֱ��ʹ��hashmap����hashset�����ļ����࣬������Ԫ�ر���
 * ͳ�Ƽ��ϵ�size���ɡ�
 */
public class Q26 {
	public int removeDuplicates(int[] nums) {
		int du = 0;
		if (nums.length == 0 || nums.length == 1)
			return nums.length;
		for (int i = 1; i < nums.length - du; i++) {
			if (nums[i] == nums[i - 1]) {
				for (int j = i; j < nums.length - du - 1; j++) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
				du++;
				i--;
			}
		}
		return nums.length - du;
	}
}
