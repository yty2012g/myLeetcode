package medium;

/*
 * 2016.7.4
 * �����Ŀ���������˵����ʹ��hashmap���������ݽṹ�����Ҫ��O��n����ʱ�临�ӶȺͳ������ռ临�Ӷȣ��Ͳ�����������
 * ������������ԭ����Ŀ˵����һ�����ֳ���1�Σ��������ֶ��������Σ�����a xor a = 0.
 * ���������ֶ���������ֻ���Ǹ�����һ�ε����ֻ�ʣ�£��������ֶ������0��
 */
public class Q136 {
	public int singleNumber(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 0)
			return 0;
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
	}
}
