package medium;

import java.util.*;

/*
 * 2016.5.16
 * 首先将字符串按照‘/’分成数组，对于每一个元素而言，要么是空，要么是“.."，要么是"."，要么是正常的文件名称
 * stack用来记录当前路径所有文件名的长度
 * 如果是..，并且stack不为空的话，弹栈，这里注意：由于每次合成路径时，都会在文件名称前加一个“/”,所以每次去除弹栈的长度+1的字符串。
 * 如果是.或者空的话，不做操作
 * 如果是正常的文件名，则将文件名加入路径，并且将长度压栈。
 * 
 * 要点。空字符串的判断方法是s.equals("")，不能写等号。
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
