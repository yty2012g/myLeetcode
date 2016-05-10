package medium;

import java.util.HashMap;
/*
 * 2016.5.1
 * ��һ����������ʱ�临�Ӷ�Ϊnƽ���ķ�����
 * �ڶ���������ʹ�ö�̬�滮��ʱ�临�Ӷ�Ϊn��
 * dp[i]=Math.min(dp[i-1]+1, i-last);
 * ��̬�滮���̵ĺ����ǣ���һ������������û�г��ֹ���i���ַ���������ظ��ִ��ĳ���Ϊ�Ե�i-1���ַ�Ϊ��β������ظ��ִ��ĳ���+1
 * �ڶ�����������ֹ���i���ַ�����Ҫô����ظ��ִ���������i���ַ��м�Ĳ���(����м����ظ�)
 * Ҫô�������Ե�i-1���ַ�Ϊ��β������ظ��ִ��ĳ���+1(�м����ظ�)
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
