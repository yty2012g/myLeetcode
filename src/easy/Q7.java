package easy;

import java.util.Stack;

/*
 * 2016.5.2
 * ʹ����һ��ջ������ÿһλ��Ȼ���ջ��ʱ�򣬰���˳�����λ�����ɣ���ڶ�λ�ͳ���10������λ����100��λ��ʹ��basic��ʾ��
 * ע�⣡������int���͵�������⣬Ҳ����һ��int����������һ����int��ʾ�ķ�Χ�ڡ�
 * ���ȼ�飬����10λ��һ��û�н����
 * ��Σ�ÿ�γ�ջ������λ�������λһ���Ǹճ�ջ�����֣��������������������������
 */
public class Q7 {
	public int reverse(int x) {
		if (x == 0)
			return 0;
		int absX = Math.abs(x);
		if (!check(absX))
			return 0;
		Stack<Integer> s = new Stack<Integer>();
		while (absX != 0) {
			s.push(absX % 10);
			absX = absX / 10;
		}
		int res = 0;
		int base = 1;
		while (!s.empty()) {
			int temp = s.pop();
			res = res + temp * base;
			if (res / base != temp)
				return 0;
			base = base * 10;
		}
		res = res * (x / Math.abs(x));
		return res;
	}

	public boolean check(int x) {
		Integer test = x;
		String s = test.toString();
		if (s.length() > 10)
			return false;
		return true;
	}
}
