package hard;

import java.util.*;
import java.util.Map.Entry;

/*
 * 2016.7.2 27ms
 * ����û����union-find�ķ�����ֱ���õ�java�ṩ��treeSet�࣬����treeSetʹ�ú��������¼Ԫ�أ����Ĭ��������ġ�
 * ���Խ�ÿһ��Ԫ�ز���TreeSet�У�Ȼ�����һ�飬�Ϳ��Եõ�����������С�
 * 
 * ����14��48�ָ��£�
 * ����Arrays�������sort������ֱ�ӱ��5ms�ˡ���
 * ���������˹鲢���򡣡������ͳ�����95%�Ĵ𰸣������union-find���������������ô��
 */
public class Q128 {
	public int longestConsecutive1(int[] nums) {
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			treeset.add(nums[i]);
		}
		Iterator<Integer> iter = treeset.iterator();
		boolean flag = false;
		int max = 1;
		int temp = 0;
		int old = 0;
		System.out.println(treeset);
		while (iter.hasNext()) {
			if (!flag) {
				flag = true;
				old = iter.next();
				temp = 1;
				continue;
			}
			int num = iter.next();
			if (num == old + 1) {
				old = num;
				temp++;
			} else {
				max = Math.max(temp, max);
				old = num;
				temp = 1;
			}
		}
		max = Math.max(max, temp);
		return max;
	}

	public int longestConsecutive2(int[] nums) {
		Arrays.sort(nums);
		boolean flag = false;
		int max = 1;
		int temp = 0;
		int old = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!flag) {
				flag = true;
				old = nums[i];
				temp = 1;
				continue;
			}
			if (nums[i] == old + 1 || nums[i] == old) {
				if (nums[i] == old)
					continue;
				old = nums[i];
				temp++;
			} else {
				max = Math.max(max, temp);
				old = nums[i];
				temp = 1;
			}
		}
		max = Math.max(max, temp);
		return max;
	}
}
