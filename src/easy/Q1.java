package easy;

import java.util.HashMap;
/*
 * 2016.5.1
 * 使用hashmap，如果找到一个数，target减去这个数也在hash表中，则返回这两个数的下标
 */

public class Q1 {
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		HashMap<Integer,Integer> array=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(array.get(target-nums[i])==null)
				array.put(nums[i], i);
			else
			{
				res[0]=array.get(target-nums[i]);
				res[1]=i;
				break;
			}
		}
		return res;
	}
}
