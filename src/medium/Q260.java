package medium;

import java.util.*;

/*
 * 2016.7.22
 * ���η���̫���
 * �����ǣ�����������򣬵õ���ͬ�������ֵ��������a^b����Ϊsum��
 * Ȼ�󣬵õ�sum�е�һ����Ϊ0��λ��ʹ��sum&-sum����Ϊ�����������Ĳ��롣�����Ϊflag��������һλ���ԣ�a��b�ǲ�ͬ�ġ���Ȼ��һ����1��һ����0
 * ���Ը�����һλ�����Խ����黮�ֳ������֣�һ������һλΪ0��һ������һλΪ1��Ȼ��ͱ���������������ֳ���2�Σ������ֳ���1�Ρ�
 * �������飬���nums[i] & flag��Ϊ0�����������������յõ���ΪΪ1���Ǹ�����
 * ����һ����������sum^��һ���Ľ����
 */
public class Q260 {
	public int[] singleNumber(int[] nums) {
		int[] res = new int[2];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum ^ nums[i];
		}
		int flag = sum & (-1 * sum);
		int a = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & flag) != 0) {
				a = a ^ nums[i];
			}
		}
		res[0] = a;
		res[1] = sum ^ a;
		return res;
	}
}
