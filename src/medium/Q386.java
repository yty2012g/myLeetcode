package medium;

import java.util.*;

/*
 * 2016.8.23
 * dfs的思想。
 * 首先，按照字典序的话，1后面应该是10，100，1000等等。
 * 因此，使用dfs递归，如果cur是小于n的直接加入后面，否则返回上一层。
 * 然后，检查字典序的下一层是否在范围内，如果10cur也在范围内，那么继续下一层。
 * 最后，检查当前层，如果是1开始，则9结束，其余都是0开始9结束。
 * 
 * 注意，这里的乘以10为什么没有检查越界呢？因为int类型的上限是2^32-1，也就是4G，如果除以10也就是400M，一个整形是4字节
 * 那么总的列表就是1.6G，我估计leetcode也不会有这么大的内存来测试，因此上限不会超过400M，因此也就不用检查越界了。
 * 
 * 最后。我发现，我的方法比目前discuss的大部分方法性能要好，真的是令人开心的一件事 ：D
 */
public class Q386 {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>(n);
		calc(res, 1, n);
		return res;
	}

	public void calc(List<Integer> list, int cur, int n) {
		if (cur <= n) {
			list.add(cur);
		} else {
			return;
		}
		if (cur * 10 <= n) {
			calc(list, cur * 10, n);
		}
		if (cur == 1 || cur % 10 == 0) {
			for (int i = cur + 1; i < (cur / 10 + 1) * 10; i++) {
				calc(list, i, n);
			}
		}

	}
}
