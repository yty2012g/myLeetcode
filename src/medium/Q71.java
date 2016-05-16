package medium;

import java.util.*;

/*
 * 2016.5.16
 * ���Ƚ��ַ������ա�/���ֳ����飬����ÿһ��Ԫ�ض��ԣ�Ҫô�ǿգ�Ҫô�ǡ�.."��Ҫô��"."��Ҫô���������ļ�����
 * stack������¼��ǰ·�������ļ����ĳ���
 * �����..������stack��Ϊ�յĻ�����ջ������ע�⣺����ÿ�κϳ�·��ʱ���������ļ�����ǰ��һ����/��,����ÿ��ȥ����ջ�ĳ���+1���ַ�����
 * �����.���߿յĻ�����������
 * ������������ļ��������ļ�������·�������ҽ�����ѹջ��
 * 
 * Ҫ�㡣���ַ������жϷ�����s.equals("")������д�Ⱥš�
 */
public class Q71 {
	public String simplifyPath(String path) {
		Stack<Integer> stack = new Stack<Integer>();
		String[] pc = path.split("/");
		String res = "";
		for (int i = 0; i < pc.length; i++) {
			if (pc[i].equals("..")) {
				if (!stack.empty())
					res = res.substring(0, res.length() - stack.pop() - 1);
			} else if (pc[i].equals(".") || pc[i].equals("")) {
			} else {
				res = res + "/" + pc[i];
				stack.push(pc[i].length());
			}
			System.out.println(stack);
		}
		if (res.equals(""))
			return "/";
		return res;
	}
}
