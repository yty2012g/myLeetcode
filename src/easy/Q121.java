package easy;

/*
 * 2016.7.2
 * 题目读了我好一会。。。
 * 大意是数组中第i项的意义代表第i天的股票
 * 你只能完成一次交易，就是买一次然后卖掉，求最大收益。
 * 方法也很简单，找到售价最低的那天买入，那天以后售价最高的卖出即可。
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
