package easy;
/*
 * 2016.5.2
 * ע��㣺
 * 1.���������ǻ�������
 * 2.���ȵõ�ԭ���ֵ�λ����Ҳ���ǵ�һ��whileѭ����
 * 3.ÿ���ж���β�Ƿ���ȡ�      
 */
public class Q9 {
	public boolean isPalindrome(int x) {
		int copy = x;
		if (x < 0)
			return false;
		if (x < 10)
			return true;
		int number = 1;
		while (copy >= 10) {
			copy = copy / 10;
			number = number * 10;
		}
		copy = x;
		while (copy != 0) {
			if (copy % 10 != copy / number)
				return false;
			copy = copy - ((copy % 10) * number);
			copy = copy / 10;
			number = number / 100;
		}
		return true;
	}
}
