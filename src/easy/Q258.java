package easy;

/*
 * 2016.7.22
 * 1.基于数学的方法，如果n是0，返回0.如果n模9为0，返回9，其余情况返回n模9
 * 2.基于循环的方法，如果当前数字大于9，则每一位加起来，得到新的数字，反复直到当前数字小于等于9.
 * 上述两个方法都是2ms。这是因为，即使最大的数字，也只用循环三次就可以了。
 * int范围最大是21亿多。则和最大的一定是1999999999，加起来也就是82，再加也就10，再加为1.所以只要三次。因此差别并不大。
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
