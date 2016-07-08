package easy;

/*
 * 2016.7.8
 * 注意，这里要将n看作无符号整数。所以不能使用算数右移(>>)，需要使用逻辑右移（>>>）。
 * 做法很简单，每一次和1做与操作，如果结果是1，则这一位也是1.count自增。n逻辑右移即可。
 * 终止条件是n等于0
 */
public class Q191 {
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >>> 1;
		}
		return count;
	}
}
