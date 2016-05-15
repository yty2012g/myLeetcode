package medium;

/*
 * 2016.5.15
 * 这道题用了二分搜索的概念。
 * 首先，int类型的范围是0x80000000到0x7fffffff，最大值为2的31次方-1，所以平方根的最大值为46340
 * 因此当x大于5时，有x的平方根小于x/2.如果x/2小于46340的话，就从1到x/2做二分搜索，否则的话就从1到46340做二分搜索。
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
