package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
 * 2016.5.4
 * 第一步，用一个hashmap记录所有的数字对应的字母。只有2-9有效，剩余无效
 * 第二步，递归，每一次得到上一次的list，然后依次在每一项的后面加上当前数字对应的字母即可。
 */
public class Q17 {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < digits.length(); i++) {
			if (digits.charAt(i) - '0' < 2 || digits.charAt(i) - '0' > 9)
				return res;
		}
		HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();
		ArrayList<Character> middle = new ArrayList<Character>();
		middle.add('a');
		middle.add('b');
		middle.add('c');
		map.put(2, middle);
		middle = new ArrayList<Character>();
		middle.add('d');
		middle.add('e');
		middle.add('f');
		map.put(3, middle);
		middle = new ArrayList<Character>();
		middle.add('g');
		middle.add('h');
		middle.add('i');
		map.put(4, middle);
		middle = new ArrayList<Character>();
		middle.add('j');
		middle.add('k');
		middle.add('l');
		map.put(5, middle);
		middle = new ArrayList<Character>();
		middle.add('m');
		middle.add('n');
		middle.add('o');
		map.put(6, middle);
		middle = new ArrayList<Character>();
		middle.add('p');
		middle.add('q');
		middle.add('r');
		middle.add('s');
		map.put(7, middle);
		middle = new ArrayList<Character>();
		middle.add('t');
		middle.add('u');
		middle.add('v');
		map.put(8, middle);
		middle = new ArrayList<Character>();
		middle.add('w');
		middle.add('x');
		middle.add('y');
		middle.add('z');
		map.put(9, middle);
		return test(digits, 0, res, map);
	}

	public List<String> test(String digits, int prefix, List<String> res, HashMap<Integer, ArrayList<Character>> map) {
		if (prefix == digits.length())
			return res;
		int number = digits.charAt(prefix) - '0';
		List<String> news = new ArrayList<String>();
		ArrayList<Character> charset = map.get(number);
		Iterator<Character> iter = charset.iterator();
		boolean flag = res.size() == 0;
		while (iter.hasNext()) {
			char t = iter.next();
			if (flag) {
				res.add(t + "");
			} else {
				Iterator<String> it = res.iterator();
				while (it.hasNext()) {
					news.add(it.next() + t);
				}
			}
		}
		res = flag ? res : news;
		return test(digits, prefix + 1, res, map);
	}

	public void print(List<String> res) {
		Iterator<String> it = res.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
