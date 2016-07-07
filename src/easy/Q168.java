package easy;

/*
 * 2016.7.7
 * 和2进制不同的时，26进制的0代表的是z。所以一方面在得到余数的时候需要判断余数是否是0，如果是0就是加上Z
 * 每次得到一位后不能直接除以26，因为余数为0时，应该减去26.所以要根据余数判断。
 */
public class Q168 {
	public String convertToTitle(int n) {
		String res = "";
		if (n <= 0)
			return res;
		while (n > 0) {
			int m = n % 26;
			char temp = m == 0 ? 'Z' : (char) ('A' + m - 1);
			res = temp + res;
			n = m == 0 ? (n - 26) / 26 : (n - m) / 26;
		}
		return res;
	}
}
