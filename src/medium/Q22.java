package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 2016.5.5
 * �����Ŀ���ǵ��͵����������������Ϊÿһ�ο���ѡ����������Ż��������ţ�������һ�Ŷ�����
 * ������Ż��������һ���ļ�֦��
 * ��һ�����������������n�ˣ�ֱ�ӷ�����һ��
 * �ڶ���ֻ���ڴ�ƥ���������������0ʱ���ܷ������š�
 * �ݹ�Ҫ�㣬ÿ�εݹ����Ҫ��һ������������ţ����ƥ�������������һ��������������һ������������ţ����ƥ�������������һ
 */
public class Q22 {
	public List<String> res;

	public List<String> generateParenthesis(int n) {
		res = new ArrayList<String>();
		solve(0, 2 * n, 0, 0, "");
		return res;
	}

	public void solve(int dep, int maxDep, int leftNum, int leftNumTotal, String s) {
		if (leftNumTotal * 2 > maxDep)
			return;

		if (dep == maxDep) {
			res.add(s);
			return;
		}

		for (int i = 0; i < 2; i++)
			if (i == 0) {
				solve(dep + 1, maxDep, leftNum + 1, leftNumTotal + 1, s + '(');
			} else {
				if (leftNum > 0)
					solve(dep + 1, maxDep, leftNum - 1, leftNumTotal, s + ')');
			}
	}
}
