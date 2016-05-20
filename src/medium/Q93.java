package medium;

import java.util.*;

/*
 * 2016.5.20
 * ʹ�û��ݵķ�������ip��ַ�е�.��Ϊ��ǣ�ÿ�����ȡ��3λ���֣�����ÿһ��ȡ�������������0�Ļ�����ͷ����Ϊ0
 * ����Ѿ�ȡ�������ָ�������ԭ�ַ����ĳ��ȣ�����.���Ѿ�������ˣ��򽫽����¼��
 */
public class Q93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() < 4)
			return res;
		String prefix = "";
		c(res, s, 0, prefix, 0);
		return res;
	}

	public void c(List<String> res, String s, int num, String prefix, int dot) {
		if (num == s.length() && dot == 4) {
			res.add(prefix.substring(0, prefix.length() - 1));
			return;
		}
		if (s.length() - num > 3 * (3 - dot + 1) || s.length() - num < (3 - dot + 1))
			return;
		int start = 1;
		int end = s.length() - num >= 3 ? 3 : s.length() - num;
		for (int i = start; i <= end; i++) {
			String te = s.substring(num, num + i);
			if (te.charAt(0) == '0' && te.length() != 1)
				continue;
			int temp = Integer.parseInt(te);
			if (temp >= 0 && temp <= 255) {
				c(res, s, num + i, prefix + s.substring(num, num + i) + ".", dot + 1);
			}
		}
	}
}
