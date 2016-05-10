package easy;

import java.util.HashMap;
import java.util.Stack;
/*
 * 2016.5.4
 * 这道题也比较简单，需要注意栈是否为空的问题。
 */
public class Q20 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
				stack.push(s.charAt(i));
			else {
				if (stack.isEmpty())
					return false;
				char p = stack.pop();
				if (s.charAt(i) != map.get(p))
					return false;
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}
}
