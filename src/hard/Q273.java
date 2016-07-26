package hard;

/*
 * 2016.7.26
 * 就是三位1组进行解释。
 * 然后把所有出现的英文，按照类别分类即可。
 */

public class Q273 {
	public String numberToWords(int num) {
		String[] ten = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen" };
		String[] tens = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] g = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		String[] w = { "", "Thousand ", "Million ", "Billion " };
		if (num == 0)
			return "Zero";
		String res = "";
		String temp = num + "";
		int flag = 0;
		while (temp.length() >= 3) {
			String t = temp.substring(temp.length() - 3);
			String r = "";
			if (t.charAt(0) != '0') {
				r = g[t.charAt(0) - '0'] + " " + "Hundred ";
			}
			if (t.charAt(1) - '0' > 1) {
				r = r + tens[t.charAt(1) - '2'] + " ";
				r = t.charAt(2) == '0' ? r : r + g[t.charAt(2) - '0'] + " ";
			} else if (t.charAt(1) == '0') {
				if (t.charAt(2) != '0') {
					r = r + g[t.charAt(2) - '0'] + " ";
				}
			} else {
				if (t.charAt(2) == '0') {
					r = r + "Ten ";
				} else {
					r = r + ten[t.charAt(2) - '0' - 1] + " ";
				}
			}
			if (r.length() > 0)
				res = r + w[flag] + res;
			flag++;
			temp = temp.substring(0, temp.length() - 3);
		}
		if (temp.length() != 0) {
			int left = Integer.parseInt(temp);
			if (left > 0 && left <= 10) {
				res = g[left] + " " + w[flag] + res;
			} else if (left >= 11 && left <= 19) {
				res = ten[left - 11] + " " + w[flag] + res;
			} else {
				if (temp.charAt(1) == '0') {
					res = tens[temp.charAt(0) - '2'] + w[flag] + res;
				} else {
					res = tens[temp.charAt(0) - '2'] + " " + g[temp.charAt(1) - '0'] + " " + w[flag] + res;
				}
			}
		}
		if (res.charAt(res.length() - 1) != ' ')
			return res;
		return res.substring(0, res.length() - 1);
	}
}
