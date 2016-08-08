package medium;

/*
 * 2016.8.8
 * �����num�ĳ���С��3������˵�����ܹ���1λ����1λ�����������ֱ�ӷ���false��
 * ��������add�����ڽ������ַ�����ӣ������ؽ�����ַ�������������ķ�ʽ���м��㡣
 * is������index��ʾ��һ����ʼ�������㣬first��ʾ��һ��������second��ʾ�ڶ�������
 * ��ʼ���������������ʼ����
 * ע�⣺���ڲ��ܳ���0xxxx��������������������ǰλ��0�Ļ�����һ����0���㡣
 * ���first��second����ʼ�������Ժ󣬼���õ�sum�����Ҽ���index��ʼ�ܷ��õ���sum�����ַ�����
 * �����������second�滻first����sum�滻second������index����ƶ�sum�ĳ��ȡ�
 * ���index�Ѿ�����num�ĳ����ˣ�����true
 * ������ΪΪ�˱�֤�ӷ���Ч�ԣ�first��second��ʼ���׶ν�ȡ����󳤶Ⱦ�Ϊʣ�³��ȵ�һ�룬���Գ�ʼ���׶��ǲ�����index����num�ĳ��ȵ�
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
