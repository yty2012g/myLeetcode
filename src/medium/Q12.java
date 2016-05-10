package medium;
/*
 * 2016.5.3
 * 像这种有限种类的题目，直接用穷举即可，不需要每一位进行判断。
 */
public class Q12 {
	public String intToRoman(int num) {
		if (num > 3999 || num < 1)
			return null;
		String[] ge = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String[] shi = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] bai = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] qian = { "", "M", "MM", "MMM" };
		String res = "";
		if (num > 0)
			res += ge[num % 10];
		num = num / 10;
		if (num > 0)
			res += shi[num % 10];
		else
			return res;
		num = num / 10;
		if (num > 0)
			res += bai[num % 10];
		else
			return res;
		num = num / 10;
		if (num > 0)
			res += qian[num % 10];
		return res;
	}
}
