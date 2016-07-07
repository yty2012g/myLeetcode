package easy;

import java.util.*;

/*
 * 2016.7.7
 * ���ַ�������һ�ַ����������뵽������Hashmap,ֻҪͳ�ƵĴ�������һ�룬ֱ�ӷ��ء�
 * �ڶ��ַ���λ���������������ֵ�ÿһ��������λ����ͳ�ƣ���Ϊmajority number���Ǵ��ڵģ���Ŀ���裩
 * ���majority number��iλΪ0����ô��һλ0���ֵĴ�������1�룬1���ֵĴ���С��һ�롣ͬ��1Ҳ��һ���ġ�
 */
public class Q169 {
	public int majorityElement(int[] nums) {
		int[] bitnum = new int[32];
		int res = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				bitnum[i] += (nums[j] >> i) & 1;
			}
			res |= ((bitnum[i] > nums.length / 2) ? 1 : 0) << i;
		}
		return res;
	}

	public int majorityElement2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
			if (map.get(nums[i]) > nums.length / 2)
				return nums[i];
		}
		return 0;
	}
}
