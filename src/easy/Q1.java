package easy;

import java.util.HashMap;
/*
 * 2016.5.1
 * ʹ��hashmap������ҵ�һ������target��ȥ�����Ҳ��hash���У��򷵻������������±�
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
