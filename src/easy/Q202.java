package easy;

import java.util.*;

/*
 * 2016.7.14
 * ��Ŀ�Ƚϼ򵥡������ֿ��ܣ���һ�־������տ��Ա��1���ڶ��־���һֱ��ѭ�������Ҳ������1
 * ʹ��hashset��¼�Ѿ����ֵ����֡�
 * ������������ֳ��ֹ�����ֱ������ѭ����
 * ������������ֵ���1����ֹѭ��������1.
 */
public class Q202 {
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		while (n != 1) {
			int nint = 0;
			while (n != 0) {
				nint = nint + (n % 10) * (n % 10);
				n = n / 10;
			}
			if (set.contains(nint))
				break;
			n = nint;
			set.add(nint);
		}
		return n == 1 ? true : false;
	}
}
