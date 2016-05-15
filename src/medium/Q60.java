package medium;

import java.util.*;

/*
 * 2016.5.15
 * ���ֵ����ǵ���������£�ȡֵ��Χ��1��n�������±��0��ʼ������ȡģ�����Է�Χ��0~n��-1
 * ʹ��һ�������¼��û���ù������֡�
 * �������£�
 * ��һ���������n�������õ���n-1������Ϊtimes
 * �ڶ������������ǰkλ�ڵڼ���(n-1)!����0��n-1��ʹ�ó������õ��ڼ�����Ȼ�������ȡ����Ӧλ�����֣�������
 * ��������k��Χ��С����n-1������times��С����n-2�������ظ���2����
 * ���Ĳ���������������һ�����֡�
 */
public class Q60 {
	public String getPermutation(int n, int k) {
		String res = "";
		int times = 1;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			times = times * i;
			list.add(i);
		}
		k--;
		times = times / n;
		for (int i = 0; i < n - 1; i++) {
			int num = k / times;
			res = res + list.get(num);
			list.remove(num);
			k = k - num * times;
			times = times / (n - 1 - i);
		}
		res = res + list.get(0);
		return res;
	}
}
