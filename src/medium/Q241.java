package medium;

import java.util.*;

/*
 * 2016.7.22
 * 分治法，什么叫做加括号，就是调整运算顺序。
 * 所以遍历input，如果出现一个符号，则符合前的算式可以得到一个结果集，符号后的算式也是一个结果集，根据符号，将两个结果集合并即可。
 */
public class Q241 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
				Iterator<Integer> itL = left.iterator();
				while (itL.hasNext()) {
					Iterator<Integer> itR = right.iterator();
					int l = itL.next();
					while (itR.hasNext()) {
						int r = itR.next();
						if (input.charAt(i) == '-')
							res.add(l - r);
						else if (input.charAt(i) == '+')
							res.add(l + r);
						else
							res.add(l * r);
					}
				}
			}
		}
		if (res.size() == 0)
			res.add(Integer.parseInt(input));
		return res;
	}
}
