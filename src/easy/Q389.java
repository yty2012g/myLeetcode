package easy;

/*
 * 2016.8.31
 * ��Ŀ�ܼ򵥣���򵥵ķ�������ʹ��hashmap��
 * ��������������Ϊt�г���һ���ַ����⣬�������ַ���������s�У�����s+tӦ�ð���������s���ַ��ټ��ϵ������Ǹ��ַ���
 * ���ԣ���s+t��ÿһ���ַ���������㣬�������ε��ַ��͵����������ֻʣ�������Ǹ��ַ���
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
