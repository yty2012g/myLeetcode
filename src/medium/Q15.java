package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
 * 2016.5.4
 * 将3sum转换成2sum的问题，主要在于去除重复。
 * 第一，3sum的第一个数使用hashmap，保证不重复。
 * 第二，2sum的第一个数使用hashmap，保证不重复。
 * 对于2sum，使用一个头指针和一个尾指针，如果和大于target，头指针移动，否则尾指针移动，如果和等于target，记录数据，两个指针都移动。
 */
public class Q15 {
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		if (len < 3)
			return null;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<len-2;i++){
			if(map.get(nums[i])!=null) continue;
			map.put(nums[i], i);
			ArrayList<ArrayList<Integer>> middle=twoSum(nums,i+1,len-1,0-nums[i]);
			if(middle.size()==0) continue;
			Iterator<ArrayList<Integer>> iter=middle.iterator();
			while(iter.hasNext()){
				ArrayList<Integer> temp=new ArrayList<Integer>();
				temp.add(nums[i]);
				ArrayList<Integer> m= iter.next();
				temp.add(m.get(0));
				temp.add(m.get(1));
				res.add(temp);
				temp=null;
			}
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> twoSum(int[] nums, int start, int end, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		if (end - start + 1 < 2)
			return res;
		int head = start;
		int foot = end;
		while (head < foot) {
			if (nums[head] + nums[foot] == target) {
				if(map.get(nums[head])==null){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[head]);
					temp.add(nums[foot]);
					map.put(nums[head], nums[foot]);
					head++;
					foot--;
					res.add(temp);
				}else{
					head++;
					foot--;
				}
			}else if(nums[head] + nums[foot] > target){
				foot--;
			}else{
				head++;
			}
		}
		return res;
	}
}