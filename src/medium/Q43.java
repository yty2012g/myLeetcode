package medium;

/*
 * 2016.5.9
 * ������ȫģ�±���ķ�ʽ���������˷��ֳ�����
 * ��һ�������������γ��Գ�����ÿһλ���ڽ�����油��Ӧ��0��
 * �ڶ���������������н����������
 * ���ԣ�and������������һ�����ֳ���һ����λ���Ľ��
 * add����������������������ӵĽ����
 */
public class Q43 {
	public String multiply(String num1, String num2) {
		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) != '0') {
				num1 = num1.substring(i, num1.length());
				break;
			}
			if (i == num1.length() - 1)
				return "0";
		}
		for (int i = 0; i < num2.length(); i++) {
			if (num2.charAt(i) != '0') {
				num2 = num2.substring(i, num2.length());
				break;
			}
			if (i == num2.length() - 1)
				return "0";
		}
		if (num1.length() < num2.length())
			return multiply(num2, num1);
		String res = "0";
		for (int i = num2.length() - 1; i >= 0; i--) {
			if (num2.charAt(i) == '0')
				continue;
			String middle = and(num1, num2.charAt(i));
			for (int j = 0; j < num2.length() - 1 - i; j++) {
				middle = middle + "0";
			}
			res = add(res, middle);
		}
		return res;
	}

	public String and(String a, char b) {
		if (b == '0')
			return "0";
		int jin = 0;
		String res = "";
		for (int i = a.length() - 1; i >= 0; i--) {
			int ander = a.charAt(i) - '0';
			int andor = b - '0';
			int middle = ander * andor + jin;
			jin = middle / 10;
			res = middle % 10 + res;
		}
		if (jin != 0)
			res = jin + res;
		return res;
	}

	public String add(String a, String b) {
		if (a.length() < b.length())
			return add(b, a);
		String res = "";
		int jin = 0;
		for (int i = b.length() - 1; i >= 0; i--) {
			int middle = a.charAt(i + a.length() - b.length()) - '0' + b.charAt(i) - '0' + jin;
			if (middle >= 10)
				jin = 1;
			else
				jin = 0;
			res = (middle % 10) + res;
		}
		if (jin == 1) {
			if (a.length() == b.length())
				res = "1" + res;
			else
				res = add(a.substring(0, a.length() - b.length()), "1") + res;
		} else if (a.length() != b.length()) {
			res = add(a.substring(0, a.length() - b.length()), "0") + res;
		}
		return res;
	}
}
