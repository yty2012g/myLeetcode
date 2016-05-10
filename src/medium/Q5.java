package medium;

public class Q5 {
	public String longestPalindrome(String s) {
		char[] sc =s.toCharArray();
		if(sc.length==1) return s;
		if(sc.length==2){
			if(sc[0]==sc[1]) return s;
			else{
				String res="";
				return res+sc[0];
			}
		}
		int [][] dp = new int[s.length()][s.length()];
		int maxP=0;
		int maxL=0;
		for(int i=0;i<s.length();i++){
			dp[i][i]=1;
			if(i<s.length()-1){
				dp[i][i+1]=sc[i]==sc[i+1]?2:0;
			}
		}
		for(int i=2;i<sc.length;i++){
			for(int j=0;j<sc.length-i;j++){
				dp[j][i+j]=sc[j]==sc[i+j]?dp[j+1][i+j-1]==0?0:dp[j+1][i+j-1]+2:0;
				if(dp[j][i+j]>maxL){
					maxL=dp[j][i+j];
					maxP=j;
				}
			}
		}
		String res="";
		for(int i=0;i<maxL;i++){
			res+=sc[i+maxP];
		}
		return res;
	}
}
