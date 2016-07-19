package medium;

import java.util.*;

/*
 * 2016.7.19
 * Ħ��ͶƱ����ͶƱ�������ǳ��ִ�������n�����֡�
 * ���ڱ�����ԣ����һ�����ֳ��ִ�������n/3�Σ���ô���ֻ���������֡�
 * ������ȵõ����ִ��������������֣�Ȼ��õ����Ǿ���ĳ��ִ������ɡ�
 */
public class Q229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0)
			return res;
		int a = 0;
		int b = 0;
		int ta = -1;
		int tb = -1;
		for (int i = 0; i < nums.length; i++) {
			if (ta == -1 || tb == -1) {
				if (ta == -1) {
					ta = 1;
					a = nums[i];
				} else if (a == nums[i]) {
					ta++;
				} else {
					tb = 1;
					b = nums[i];
				}
				continue;
			}
			if (a == nums[i] || b == nums[i]) {
				ta = a == nums[i] ? ta + 1 : ta;
				tb = b == nums[i] ? tb + 1 : tb;
			} else if (ta == 0 || tb == 0) {
				if (ta == 0) {
					a = nums[i];
					ta = 1;
				} else {
					b = nums[i];
					tb = 1;
				}
			} else {
				ta--;
				tb--;
			}
		}
		ta = 0;
		tb = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a)
				ta++;
			else if (nums[i] == b)
				tb++;
		}
		if (ta > nums.length / 3)
			res.add(a);
		if (tb > nums.length / 3)
			res.add(b);
		return res;
	}
}
