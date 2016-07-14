package easy;

import java.util.*;

/*
 * 2016.7.14
 * ��������ж�������һ�㷽����
 * ��2��ʼ����2�����б������޳���
 * Ȼ���ҵ���һ��û�б��޳������֣��������ֵĴ�����1��
 */
public class Q204 {
	public int countPrimes(int n) {
		if (n == 0)
			return 0;
		int count = 0;
		byte[] num = new byte[n];
		for (int i = 1; i < n - 1; i++) {
			if (num[i] != 0)
				continue;
			count++;
			for (int j = i + i + 1; j < n; j = j + i + 1) {
				num[j] = 1;
			}
		}
		return count;
	}
}
