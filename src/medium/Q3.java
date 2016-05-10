package medium;

import java.util.HashMap;
/*
 * 2016.5.1
 * 第一个方法，是时间复杂度为n平方的方法。
 * 第二个方法，使用动态规划，时间复杂度为n。
 * dp[i]=Math.min(dp[i-1]+1, i-last);
 * 动态规划方程的含义是，第一种情况，如果还没有出现过第i个字符，则最长无重复字串的长度为以第i-1个字符为结尾的最长无重复字串的长度+1
 * 第二种情况，出现过第i个字符，则，要么最长无重复字串是两个第i个字符中间的部分(如果中间无重复)
 * 要么，则是以第i-1个字符为结尾的最长无重复字串的长度+1(中间有重复)
 */
public class Q3 {
	public int lengthOfLongestSubstring(String s) {
		char[] sc=s.toCharArray();
		HashMap<Character,Integer> hashmap=new HashMap<Character,Integer>();
		int stringlength=0;
		String res="";
		for(int i=0;i<sc.length;i++){
			hashmap=new HashMap<Character,Integer>();
			int templength=0;
			String temp="";
			for(int j=i;j<sc.length;j++){
				if(hashmap.get(sc[j])==null){
					templength++;
					temp+=sc[j];
					hashmap.put(sc[j], j);
				}
				else{
					break;
				}
			}
			if(templength>stringlength){
				stringlength=templength;
				res=temp;
			}
		}
		return stringlength;
	}
	public int dynamicP(String s){
		if(s.length()==0)return 0;
		char[] sc=s.toCharArray();
		HashMap<Character,Integer> hashmap=new HashMap<Character,Integer>();
		int[] dp=new int[sc.length];
		dp[0]=1;
		hashmap.put(sc[0], 0);
		int max=dp[0];
		for(int i=1;i<sc.length;i++){
			int last=-1;
			if(hashmap.get(sc[i])!=null) last=hashmap.get(sc[i]);
			if(last==-1){
				dp[i]=dp[i-1]+1;
			}else{
				dp[i]=Math.min(dp[i-1]+1, i-last);
			}
			max=dp[i]>max?dp[i]:max;
			hashmap.put(sc[i], i);
		}
		return max;
	}
}
