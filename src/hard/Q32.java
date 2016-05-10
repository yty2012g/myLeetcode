package hard;
/*
 * 2016.5.8
 * 典型动态规划问题
 * dp[i]表示以第i-1个字符为结尾的合法括号组
 * 初始化，dp[0]自然是0，dp[1]因为此时只有一个字符，一定不是合法括号组，所以也是0
 * 如果第i-1个字符是（，直接等于0，因为左括号不能成为合法括号组的结尾
 * 如果第i-1个字符是），第一种情况是第i-2个字符是（，那么直接dp[i]=dp[i-2]+2即可，这里不用担心i-2越界，因为dp是从0到s.length
 * 第二种情况是第i-2个字符是），那么如果dp[i-1]不等于0，说明前面那个）可以组成一个合法的括号组，那么只要这个合法的括号组前面的一个字符是（就行了
 * 所以dp[i]=dp[i-1]+2,但是还有情况就是，第i-1个字符匹配的（前面是个合法的括号组，所以应该加上前面合法括号组的长度
 * 所以最终的dp[i]=dp[i-1]+2+dp[i-2-dp[i-1]];
 */
public class Q32 {
	public int longestValidParentheses(String s) {
		int[] dp=new int[s.length()+1];
		int max=0;
		if(s.length()==0) return max;
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<dp.length;i++){
			if(s.charAt(i-1)=='('){
				dp[i]=0;
			}else{
				if(s.charAt(i-2)=='('){
					dp[i]=dp[i-2]+2;
				}else if(dp[i-1]!=0){
					if(i-2-dp[i-1]>=0 && s.charAt(i-2-dp[i-1])=='('){
						dp[i]=dp[i-1]+2+dp[i-2-dp[i-1]];
					}
					else dp[i]=0;
				}
			}
			max=dp[i]>max?dp[i]:max;
		}
		return max;
	}
}
