package medium;

/*
 * 2016.7.2
 * ��Q121��ͬ���ǣ�Q122���Թ����ι�Ʊ������һ��Ҫ����������
 * �Ǿ��뷨�ܼ��ˣ���̰���㷨���������ϵ�Ǯ�����ϡ�
 * ֻҪ����Ĺ�Ʊ�������û�е�����ô�ҾͲ��򣬴�ʱ�ҵ�������Ƚ������Ĳ��־��ǹɼ����ǵĲ��֡�
 * ������ˣ�����������ӵ��쿪ʼ�µ�һ�ּ��㡣
 */
public class Q122 {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1)
			return 0;
		int res = 0;
		int temp = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				temp = temp + prices[i] - prices[i - 1];
				if (i == prices.length - 1) {
					res = res + temp;
				}
			} else {
				res = res + temp;
				temp = 0;
			}
		}
		return res;
	}
}
