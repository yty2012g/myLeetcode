package easy;

/*
 * 2016.7.22
 * 1.������ѧ�ķ��������n��0������0.���nģ9Ϊ0������9�������������nģ9
 * 2.����ѭ���ķ����������ǰ���ִ���9����ÿһλ���������õ��µ����֣�����ֱ����ǰ����С�ڵ���9.
 * ����������������2ms��������Ϊ����ʹ�������֣�Ҳֻ��ѭ�����ξͿ����ˡ�
 * int��Χ�����21�ڶࡣ�������һ����1999999999��������Ҳ����82���ټ�Ҳ��10���ټ�Ϊ1.����ֻҪ���Ρ���˲�𲢲���
 */
public class Q258 {
	public int addDigits(int num) {
		int res = num;
		while (res > 9) {
			int copy = 0;
			while (res > 0) {
				copy = res % 10;
				res = res / 10;
			}
			res = copy;
		}
		return res;
	}

	public int addDigits2(int num) {
		if (num == 0)
			return 0;
		else if (num % 9 == 0)
			return 9;
		else
			return num % 9;
	}
}
