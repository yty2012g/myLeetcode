package medium;

import java.util.*;

/*
 * 2016.7.22
 * ���η���ʲô���������ţ����ǵ�������˳��
 * ���Ա���input���������һ�����ţ������ǰ����ʽ���Եõ�һ������������ź����ʽҲ��һ������������ݷ��ţ�������������ϲ����ɡ�
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
