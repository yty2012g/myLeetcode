package medium;

import java.util.*;

/*
 * 2016.7.14
 * �����Ļ����ǿ���λ����ġ�
 * ���ȣ�ʹ��һ��list����¼Ŀǰ��û�г��ֹ�0��λ��
 * �����ÿһ����Χ�����ֶ�Ҫͳ��ÿһλ�Ļ���TLE
 * Ȼ��list�ĵ�һ�����ִ���Ŀǰ��û�г��ֹ�0�����λ��
 * �����뷨�������ģ��������һ����x��������һλ���0�����Ҽ������Ȼ�ڷ�Χ�ڣ���ô�м���������ֶ������ж��ˡ�
 * ���Զ���i������list�ĵ�һλ��n,�Ƚ�i>>n,�ٽ�,i<<n��Ȼ�����1<<n��������ڷ�Χ�ڣ���ô��һλ�϶������0��
 * ����ÿ�������ܶ����֣�ʱ��������㡣
 */
public class Q201 {
	public int rangeBitwiseAnd(int m, int n) {
		int length = Integer.toBinaryString(m).length();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < length; i++) {
			list.add(i);
		}
		for (int i = m; i <= n && i >= 0;) {
			for (int j = 0; j < list.size(); j++) {
				if (((i >> list.get(j)) & 1) == 0) {
					list.remove(j);
					j--;
				}
			}
			if (list.size() == 0)
				return 0;
			i = i >> list.get(0);
			i = i << list.get(0);
			i = i + (1 << list.get(0));
		}
		int res = 0;
		for (int i = 0; i < list.size(); i++) {
			res |= 1 << list.get(i);
		}
		return res;
	}

	public int rangeBitwiseAnd2(int m, int n) {
		int res = 0;
		boolean flag = true;
		int length = Integer.toBinaryString(m).length();
		for (int i = 0; i <= length; i++) {
			for (int j = m; j <= n; j++) {
				if (((j >> i) & 1) == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				res |= 1 << i;
			} else {
				res |= 0 << i;
			}
			flag = true;
		}
		return res;
	}
}
