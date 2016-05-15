package easy;

/*
 * 2016.5.15
 * ������������ֿ��ַ������0��
 * Ȼ�󽫽����Ƚ϶̵�b�ڿ�ͷ��0�����aһ���ĳ��ȡ�
 * Ȼ�������ӡ�
 * ������������н�λ����ͷ��1��
 */
public class Q67 {
	public String addBinary(String a, String b) {
		if (a.length() == 0)
			a = "0";
		if (b.length() == 0)
			b = "0";
		if (b.length() > a.length())
			return addBinary(b, a);
		String res = "";
		int jin = 0;
		while (b.length() != a.length()) {
			b = "0" + b;
		}
		for (int i = a.length() - 1; i >= 0; i--) {
			int numA = a.charAt(i) - '0';
			int numB = b.charAt(i) - '0';
			jin = numA + numB + jin >= 2 ? 1 : 0;
			int sum = numA + numB + jin >= 2 ? numA + numB + jin - 2 : numA + numB + jin;
			res = sum + res;
		}
		if (jin == 1)
			res = "1" + res;
		return res;
	}
}
