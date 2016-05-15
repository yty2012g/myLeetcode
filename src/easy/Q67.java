package easy;

/*
 * 2016.5.15
 * 首先是如果出现空字符，变成0；
 * 然后将将长度较短的b在开头用0补齐和a一样的长度。
 * 然后就是相加。
 * 最后加完如果还有进位，则开头补1。
 */
public class Q67 {
	public String addBinary(String a, String b) {
		if (a.length() == 0)
			a = "0";
		if (b.length() == 0)
			b = "0";
		if (b.length() > a.length())
			return addBinary(b, a);
		String res = "";
		int jin = 0;
		while (b.length() != a.length()) {
			b = "0" + b;
		}
		for (int i = a.length() - 1; i >= 0; i--) {
			int numA = a.charAt(i) - '0';
			int numB = b.charAt(i) - '0';
			jin = numA + numB + jin >= 2 ? 1 : 0;
			int sum = numA + numB + jin >= 2 ? numA + numB + jin - 2 : numA + numB + jin;
			res = sum + res;
		}
		if (jin == 1)
			res = "1" + res;
		return res;
	}
}
