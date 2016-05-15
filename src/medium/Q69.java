package medium;

/*
 * 2016.5.15
 * ��������˶��������ĸ��
 * ���ȣ�int���͵ķ�Χ��0x80000000��0x7fffffff�����ֵΪ2��31�η�-1������ƽ���������ֵΪ46340
 * ��˵�x����5ʱ����x��ƽ����С��x/2.���x/2С��46340�Ļ����ʹ�1��x/2����������������Ļ��ʹ�1��46340������������
 */
public class Q69 {
	public int mySqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		if (x == 2 || x == 3)
			return 1;
		if (x == 4 || x == 5)
			return 2;
		if (x / 2 < 46340)
			return my(x, 1, x / 2);
		else
			return my(x, 1, 46340);
	}

	public int my(int x, int start, int end) {
		if (start * start == x)
			return start;
		if (end * end == x)
			return end;
		if (start + 1 == end)
			return end * end > x ? start : end;
		int num = (start + end) / 2;
		if (num * num == x)
			return num;
		else if (num * num > x)
			return my(x, start, num);
		else
			return my(x, num, end);
	}
}
