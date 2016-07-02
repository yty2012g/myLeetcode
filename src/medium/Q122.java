package medium;

/*
 * 2016.7.2
 * 和Q121不同的是，Q122可以购买多次股票，但是一定要先买再卖。
 * 那就想法很简单了，用贪心算法，把能挣上的钱都挣上。
 * 只要当天的股票相比昨天没有跌，那么我就不买，此时我的利润相比较昨天多的部分就是股价上涨的部分。
 * 如果跌了，立马就卖。从当天开始新的一轮计算。
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
