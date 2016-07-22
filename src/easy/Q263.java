package easy;

/*
 * 2016.7.22
 * 不要想的太复杂。。
 * 如果一个数的所有质因数只包含2，3，5，那么当一个数不断地整除2，3，5后，最后只会剩下1.因为其他的质因数是不能整除2，3，5.
 * 因此，使用while循环将num的所有包含2，3，5的因数剔除。剩下的如果不是1，那么则存在其他质因数。
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
