package easy;


/*
 * 2016.5.2
 * ά����һ��times���飬��ʾ����ַ�������֮���εĵڼ��㡣
 * ����ÿһ��������ɡ�
 * ���Ǳ߽�������ַ���Ϊ�ջ��߳���Ϊ1������numRows����1������ԭ�ַ�����
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
