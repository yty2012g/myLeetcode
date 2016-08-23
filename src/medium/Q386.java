package medium;

import java.util.*;

/*
 * 2016.8.23
 * dfs��˼�롣
 * ���ȣ������ֵ���Ļ���1����Ӧ����10��100��1000�ȵȡ�
 * ��ˣ�ʹ��dfs�ݹ飬���cur��С��n��ֱ�Ӽ�����棬���򷵻���һ�㡣
 * Ȼ�󣬼���ֵ������һ���Ƿ��ڷ�Χ�ڣ����10curҲ�ڷ�Χ�ڣ���ô������һ�㡣
 * ��󣬼�鵱ǰ�㣬�����1��ʼ����9���������඼��0��ʼ9������
 * 
 * ע�⣬����ĳ���10Ϊʲôû�м��Խ���أ���Ϊint���͵�������2^32-1��Ҳ����4G���������10Ҳ����400M��һ��������4�ֽ�
 * ��ô�ܵ��б����1.6G���ҹ���leetcodeҲ��������ô����ڴ������ԣ�������޲��ᳬ��400M�����Ҳ�Ͳ��ü��Խ���ˡ�
 * 
 * ����ҷ��֣��ҵķ�����Ŀǰdiscuss�Ĵ󲿷ַ�������Ҫ�ã���������˿��ĵ�һ���� ��D
 */
public class Q386 {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>(n);
		calc(res, 1, n);
		return res;
	}

	public void calc(List<Integer> list, int cur, int n) {
		if (cur <= n) {
			list.add(cur);
		} else {
			return;
		}
		if (cur * 10 <= n) {
			calc(list, cur * 10, n);
		}
		if (cur == 1 || cur % 10 == 0) {
			for (int i = cur + 1; i < (cur / 10 + 1) * 10; i++) {
				calc(list, i, n);
			}
		}

	}
}
