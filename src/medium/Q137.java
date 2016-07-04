package medium;

import java.util.Arrays;

/*
 * 2016.7.4
 * ����1������Arrays�ķ�������������ô����һ�ε��Ǹ������������ߵĶ�����ͬ����ʱ���ɵó���
 * ����2��ʹ��һ��32λ���������飬��¼ÿһλ���ֵĴ�����ֻ����һ�ε��Ǹ�������Ӧ�Ķ�����λ���ֵĴ���һ����ģ3��1�ģ����ͨ���������飬�Ϳ��Ի�ԭԭʼ����
 */
public class Q137 {
	public int singleNumber(int[] nums) {
		int[] bitnum = new int[32];
		int res = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; i++) {
				bitnum[i] += (nums[j] >> i) & 1;
			}
			res |= (bitnum[i] % 3) << i;
		}
		return res;
	}
}
