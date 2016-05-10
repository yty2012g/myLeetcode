package easy;
/*
 * 2016.5.2
 * 注意点：
 * 1.负数都不是回文数字
 * 2.首先得到原数字的位数，也就是第一个while循环。
 * 3.每次判断收尾是否相等。      
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
