package medium;

/*
 * 2016.8.8
 * 如果，num的长度小于3，就是说不可能构成1位数加1位数的情况，则直接返回false；
 * 辅助方法add，用于将两个字符串相加，并返回结果的字符串，仿照手算的方式进行计算。
 * is方法，index表示下一步开始计算的起点，first表示第一个加数，second表示第二个加数
 * 初始情况将两个加数初始化。
 * 注意：由于不能出现0xxxx这样的情况，所以如果当前位是0的话，则一律以0计算。
 * 如果first和second都初始化好了以后，计算得到sum，并且检查从index开始能否获得等于sum的子字符串，
 * 如果可以则用second替换first，用sum替换second，并且index向后移动sum的长度。
 * 如果index已经等于num的长度了，返回true
 * 这是因为为了保证加法有效性，first和second初始化阶段截取的最大长度均为剩下长度的一半，所以初始化阶段是不可能index等于num的长度的
 */
public class Q306 {
	public boolean isAdditiveNumber(String num) {
		if (num.length() < 3)
			return false;
		return is(num, 0, "", "");
	}

	public boolean is(String num, int index, String first, String second) {
		if (num.length() == index)
			return true;
		if (first.length() == 0) {
			if (num.charAt(index) == '0') {
				if (is(num, index + 1, "0", second))
					return true;
			} else {
				for (int i = index + 1; i <= (index + num.length()) / 2; i++) {
					if (is(num, i, num.substring(index, i), second))
						return true;
				}
			}
		} else if (second.length() == 0) {
			if (num.charAt(index) == '0') {
				if (is(num, index + 1, first, "0"))
					return true;
			} else {
				for (int i = index + 1; i <= (index + num.length()) / 2; i++) {
					if (is(num, i, first, num.substring(index, i)))
						return true;
				}
			}
		} else {
			String sum = add(first, second);
			if (index + sum.length() <= num.length() && sum.equals(num.substring(index, index + sum.length()))) {
				if (is(num, index + sum.length(), second, sum))
					return true;
			}
		}
		return false;
	}

	public String add(String a, String b) {
		if (a.length() < b.length())
			return add(b, a);
		int jin = 0;
		String res = "";
		for (int i = b.length() - 1; i >= 0; i--) {
			int n = (a.charAt(a.length() - b.length() + i) - '0') + (b.charAt(i) - '0') + jin;
			if (n >= 10) {
				jin = 1;
				res = n - 10 + res;
			} else {
				jin = 0;
				res = n + res;
			}
		}
		if (jin == 1) {
			if (a.length() == b.length())
				return "1" + res;
			else {
				return add(a.substring(0, a.length() - b.length()), "1") + res;
			}
		} else {
			if (a.length() == b.length())
				return res;
			else
				return a.substring(0, a.length() - b.length()) + res;
		}
	}
}
