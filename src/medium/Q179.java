package medium;

import java.util.*;

/*
 * 2016.7.8
 * 1.这个不是按照字典序排序的。准确的说应该是这样，对于a，b两个数字如果字符串a+b>字符串b+a，则a>b
 * 2.根据1，在TreeSet实现一个comparator。
 * 3.将所有数字放入。
 * 4.为了避免所有数字均为0的情况，需要最后做一步处理，从第一位开始找到第一个不为0的数字，然后得到子字符串即可。
 */
public class Q179 {
	public String largestNumber(int[] nums) {
		TreeSet<Integer> map = new TreeSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String one = new String();
				String two = new String();
				one += o1;
				one += o2;
				two += o2;
				two += o1;
				return one.compareTo(two) > 0 ? 1 : -1;
			}
		});
		for (int i = 0; i < nums.length; i++) {
			map.add(nums[i]);
		}
		System.out.println(map);
		String res = "";
		Iterator<Integer> iter = map.iterator();
		while (iter.hasNext()) {
			res = iter.next() + res;
		}
		boolean flag = false;
		for (int i = 0; i < res.length() - 1; i++) {
			if (res.charAt(i) != '0') {
				res = res.substring(i);
				flag = true;
				break;
			}
		}
		if (!flag)
			return res.substring(res.length() - 1, res.length());
		return res;
	}
}
