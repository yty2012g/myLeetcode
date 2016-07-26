package hard;

import java.util.*;

public class Q282 {
	List<String> res = new ArrayList<String>();

	public List<String> addOperators(String num, int target) {
		calc(num, false, "", 0, target);
		return res;
	}

	public void calc(String num, boolean flag, String prefix, int flagNum, int target) {
		if (prefix.length() == 0) {
			calc(num.substring(1), false, prefix + num.charAt(0), 0, target - (num.charAt(0) - '0'));
			if (num.length() > 1)
				calc(num.substring(2), true, num.charAt(0) + "*" + num.charAt(1),
						(num.charAt(0) - '0') * (num.charAt(1) - '0'), target);
			return;
		}
		if (num.length() == 0) {
			if (flagNum == target) {
				res.add(prefix);
			}
			return;
		}
		if (num.length() == 1) {
			int number = Integer.parseInt(num);
			if (flag) {
				if (target == flagNum + number) {
					res.add(prefix + "+" + number);
				}
				if (target == flagNum - number) {
					res.add(prefix + "-" + number);
				}
				if (target == flagNum * number) {
					res.add(prefix + "*" + number);
				}
			} else {
				if (target == number) {
					res.add(prefix + "+" + number);
				}
				if (target == 0 - number) {
					res.add(prefix + "-" + number);
				}
			}
			return;
		}
		int number = num.charAt(0) - '0';
		if (flag) {
			calc(num.substring(1), false, prefix + "+" + number, 0, target - number - flagNum);
			calc(num.substring(1), false, prefix + "-" + number, 0, target + number - flagNum);
			calc(num.substring(1), true, prefix + "*" + number, flagNum * number, target);
		} else {
			calc(num.substring(1), false, prefix + "+" + number, 0, target - number);
			calc(num.substring(1), false, prefix + "-" + number, 0, target + number);
			int nb = num.charAt(1) - '0';
			calc(num.substring(2), true, prefix + "+" + number + "*" + nb, number * nb, target);
			calc(num.substring(2), true, prefix + "-" + number + "*" + nb, -1 * number * nb, target);
		}
	}
}
