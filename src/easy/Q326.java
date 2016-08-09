package easy;

/*
 * 2016.8.9
 * 使用int能表示的最大的3的幂次方来做整除运算。
 * 因为这个数字只包含3的幂次方作为因数，因此如果能整除则说明是3的幂次方。
 */
public class Q326 {
	public boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;
		return 1162261467 % n == 0;
	}
}
