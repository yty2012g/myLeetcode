package easy;

/*
 * 2016.7.22
 * ��Ҫ���̫���ӡ���
 * ���һ����������������ֻ����2��3��5����ô��һ�������ϵ�����2��3��5�����ֻ��ʣ��1.��Ϊ�������������ǲ�������2��3��5.
 * ��ˣ�ʹ��whileѭ����num�����а���2��3��5�������޳���ʣ�µ��������1����ô�����������������
 */

public class Q263 {
	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		if (num <= 6)
			return true;
		while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
			if (num % 2 == 0) {
				num = num / 2;
			}
			if (num % 3 == 0) {
				num = num / 3;
			}
			if (num % 5 == 0) {
				num = num / 5;
			}
		}
		return num == 1;
	}
}
