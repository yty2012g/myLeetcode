package medium;

import java.util.*;

/*
 * 2016.7.8
 * 1.������ǰ����ֵ�������ġ�׼ȷ��˵Ӧ��������������a��b������������ַ���a+b>�ַ���b+a����a>b
 * 2.����1����TreeSetʵ��һ��comparator��
 * 3.���������ַ��롣
 * 4.Ϊ�˱����������־�Ϊ0���������Ҫ�����һ�������ӵ�һλ��ʼ�ҵ���һ����Ϊ0�����֣�Ȼ��õ����ַ������ɡ�
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
