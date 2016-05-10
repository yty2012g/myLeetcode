package easy;
/*
 * 2016.5.3 
 * minus�������������ַ����Ĺ���ǰ׺
 * Ȼ���ͷ��ʼ�������������������ַ����Ĺ���ǰ׺���ں�֮ǰ�Ĺ���ǰ׺һ����ǰ׺���õ����յĹ���ǰ׺��
 */
public class Q14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if(strs.length==1) return strs[0];
		String res="";
		for(int i=0;i<strs.length-1;i++){
			if(i!=0){
				res=minus(res,minus(strs[i],strs[i+1]));
				if(res=="") return res;
			}else{
				res=minus(strs[i],strs[i+1]);
			}
		}
		return res;
	}
	public String minus(String a,String b){
		int min=Math.min(a.length(), b.length());
		if(min==0) return "";
		int flag=0;
		for(int i=0;i<min;i++){
			if(a.charAt(i)==b.charAt(i)) flag++;
			else break;
		}
		return a.substring(0,flag);
	}
}
