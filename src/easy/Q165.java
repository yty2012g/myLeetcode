package easy;

/*
 * 2016.7.6
 * 这个题目，首先利用String类的split方法，将version分割。
 *             **注意**
 *        split方法里面的参数是正则表达式，所以如果是.的话，要加上转义
 * 其他就比较常规了。找到比较长的那个，每一个数字进行比较。
 */
public class Q165 {
	public int compareVersion(String version1, String version2) {
		String[] one = version1.split("\\.");
		String[] two = version2.split("\\.");
		if (one.length > two.length) {
			for (int i = 0; i < one.length; i++) {
				int a = Integer.parseInt(one[i]);
				int b = i < two.length ? Integer.parseInt(two[i]) : 0;
				if (a > b)
					return 1;
				else if (b > a)
					return -1;
			}
		} else {
			for (int i = 0; i < two.length; i++) {
				int b = Integer.parseInt(two[i]);
				int a = i < one.length ? Integer.parseInt(one[i]) : 0;
				if (a > b)
					return 1;
				else if (b > a)
					return -1;
			}
		}
		return 0;
	}
}
