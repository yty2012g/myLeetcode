package easy;

import java.util.*;

/*
 * 2016.7.18
 * �������Ҳ�Ƚϼ򵥡�����ʹ��һ��hashTable�����hashtable�����˵�ǰ���������֣��򷵻�true�����򷵻�false��
 */
public class Q217 {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
