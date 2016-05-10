package easy;


/*
 * 2016.5.2
 * 维护了一个times数组，表示这个字符出现在之字形的第几层。
 * 根据每一层遍历即可。
 * 考虑边界情况，字符串为空或者长度为1，或者numRows等于1，返回原字符串。
 * 
 */
public class Q6 {
	public String convert(String s, int numRows) {
		char[] sc=s.toCharArray();
		if(sc.length==0 || sc.length==1 || numRows==1)return s;
		String res="";
		int[] times=new int[sc.length];
		int add=0;
		int t=1;
		for(int i=0;i<sc.length;i++){
			times[i]=add;
			if(add==numRows-1) t=-1;
			if(add==0) t=1;
			add=add+t;
		}
		for(int i=0;i<numRows;i++){
			for(int j=0;j<times.length;j++){
				if(times[j]==i) res=res+sc[j];
			}
		}
		return res;
	}

}
