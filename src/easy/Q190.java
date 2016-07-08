package easy;

/*
 * 2016.7.8
 * 首先将数字转换成二进制字符串，从二进制字符串的最后一位开始左移。
 * 注意：当左移（<<）和加号(+)在一起是，先算加号，再算左移。所以如果先左移再加的话，需要加上括号。
 */
public class Q190 {
	public int reverseBits(int n) {
		String bin = Integer.toBinaryString(n);
		int res = 0;
		int count = 0;
		for (int i = bin.length() - 1; count != 32; i--, count++) {
			if (i >= 0) {
				res = (res << 1) + (bin.charAt(i) - '0');
			} else {
				res = res << 1;
			}
		}
		return res;
	}
}
