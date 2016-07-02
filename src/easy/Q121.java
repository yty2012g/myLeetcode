package easy;

/*
 * 2016.7.2
 * ��Ŀ�����Һ�һ�ᡣ����
 * �����������е�i�����������i��Ĺ�Ʊ
 * ��ֻ�����һ�ν��ף�������һ��Ȼ����������������档
 * ����Ҳ�ܼ򵥣��ҵ��ۼ���͵��������룬�����Ժ��ۼ���ߵ��������ɡ�
 */
public class Q121 {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1)
			return 0;
		int min = 0;
		int mp = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[min])
				min = i;
			mp = Math.max(mp, prices[i] - prices[min]);
		}
		return mp;
	}
}
