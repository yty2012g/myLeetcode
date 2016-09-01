package easy;

/*
 * 2016.8.31
 * 题目很简单，最简单的方法就是使用hashmap。
 * 这个做法很巧妙，因为t中除了一个字符以外，其他的字符都出现在s中，所以s+t应该包含两倍的s的字符再加上单独的那个字符。
 * 所以，对s+t的每一个字符做异或运算，出现两次的字符就抵消掉，最后只剩单独的那个字符。
 */
public class Q389 {
	public char findTheDifference(String s, String t) {
		char[] c = (s + t).toCharArray();
		int res = 0;
		for (char cc : c) {
			res ^= cc;
		}
		return (char) res;
	}
}
