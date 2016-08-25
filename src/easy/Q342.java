package easy;

/*
 * 2016.8.25
 * 想不到1ms的办法。这个方法就是将所有的4的幂次方列出来，依次判断即可。O(1)时间复杂度。
 */

public class Q342 {
	public boolean isPowerOfFour(int num) {
		return num == 0x1 || num == 0x4 || num == 0x10 || num == 0x40 || num == 0x100 || num == 0x400 || num == 0x1000
				|| num == 0x4000 || num == 0x10000 || num == 0x40000 || num == 0x100000 || num == 0x400000
				|| num == 0x1000000 || num == 0x4000000 || num == 0x10000000 || num == 0x40000000;
	}
}
