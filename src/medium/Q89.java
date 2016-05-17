package medium;

import java.util.*;

/*
 * 2016.5.17
 * ������
 * �����õķ����Ƚϲڣ����Ǻܺ���⡣
 * ����nλ�����룬����n-1λ���������ɵġ�
 * �ֳ������֣���һ���֣���n-1λ�����и�����ǰ���0��˳���¼��
 * �ڶ����֣���n-1λ�����и�����ǰ���1�������¼������
 * �ݹ��һ��ʵ�ַ�ʽ��
 */
public class Q89 {
	public List<Integer> grayCode(int n) {
		if (n == 0) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(0);
			return res;
		}
		if (n == 1) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(0);
			res.add(1);
			return res;
		}
		ArrayList<String> prev = new ArrayList<String>();
		prev.add("0");
		prev.add("1");
		ArrayList<String> res = new ArrayList<String>();
		int times = 1;
		while (times != n) {
			for (int i = 0; i < prev.size(); i++) {
				res.add("0" + prev.get(i));
			}
			for (int i = prev.size() - 1; i >= 0; i--) {
				res.add("1" + prev.get(i));
			}
			prev = new ArrayList<String>();
			prev = (ArrayList<String>) res.clone();
			res = new ArrayList<String>();
			times++;
		}
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (int i = 0; i < prev.size(); i++) {
			r.add(b2i(prev.get(i)));
		}
		return r;
	}

	public int b2i(String s) {
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '1')
				res = (int) (res + Math.pow(2, s.length() - 1 - i));
		}
		return res;
	}
}
