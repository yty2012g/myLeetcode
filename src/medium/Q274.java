package medium;

import java.util.Arrays;

/*
 * 2016.7.26
 * ���ȶ������������ʱ�临�Ӷ�ΪO(nlogn)
 * Ȼ��ʹ�ö���������˼�롣
 * ����һ�����飬�������h����ô��len-h��ʼ�����ֶ��Ǵ��ڵ���h��֮ǰ�����ֶ���С�ڵ���h��
 * ���ȴ��������鿪ʼ���֣��õ�middle����ôh�͵���len-middle
 * ���middleλ�õ�Ԫ�ش���h�����middle�Ѿ�����0���򲻱ؼ����ң���ʱ��h���ֱ�ӷ��ء�
 *                            ���middle-1λ�õ�Ԫ��Ҳǡ��С�ڵ���h�����ڴ�ʱ����������ômiddle֮ǰ��Ԫ��Ҳ����С�ڵ���h�ġ�ֱ�ӷ���h��
 * ��������h�ķ�Χ����big����middle����Ϊh=len-middle����Сbig���ͼ�Сmiddle�����������h��
 * ���middleλ�õ�Ԫ��С��h����ô��Сh�ķ�Χ����ʱsmall+1��Ȼ���������������
 * ���small������big��û�еõ�h���򷵻�0��
 */
public class Q274 {
	public int hIndex(int[] citations) {
		if (citations.length == 0)
			return citations.length;
		if (citations.length == 1) {
			if (citations[0] == 0)
				return 0;
			else
				return 1;
		}
		Arrays.sort(citations);
		int small = 0;
		int big = citations.length - 1;
		while (small <= big) {
			int middle = (small + big) / 2;
			int h = citations.length - middle;
			if (citations[middle] >= h) {
				if (middle == 0)
					return h;
				else {
					if (citations[middle - 1] <= h) {
						return h;
					} else {
						big = middle;
					}
				}
			} else {
				small = middle + 1;
			}
		}
		return 0;
	}
}
