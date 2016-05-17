package easy;

/*
 * 2016.5.17
 * �ϲ��������飬�ŵ���һ�������У���ô�ʹӽ�β��ʼ��Ҳ����λ��Ϊm+n-1��Ԫ�ؿ�ʼ��
 * ʹ��index1��index2�ֱ����������鵱ǰ������±ꡣ
 * ���һ�������Ѿ������ˣ���ֱ�ӿ���һ�����鼴�ɡ�
 */
public class Q88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0)
			return;
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}
		if (nums2[0] >= nums1[m - 1]) {
			for (int i = m; i < m + n; i++) {
				nums1[i] = nums2[i - m];
			}
			return;
		}
		if (nums1[0] >= nums2[n - 1]) {
			for (int i = n + m - 1; i >= n; i--) {
				nums1[i] = nums1[i - n];
			}
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}
		int index1 = m - 1;
		int index2 = n - 1;
		for (int i = m + n - 1; i >= 0; i--) {
			if (index1 >= 0 && index2 >= 0) {
				if (nums2[index2] > nums1[index1]) {
					nums1[i] = nums2[index2];
					index2--;
				} else {
					nums1[i] = nums1[index1];
					index1--;
				}
			} else if (index2 >= 0) {
				for (int j = index2; j >= 0; j--) {
					nums1[index2] = nums2[index2];
				}
				break;
			} else {
				for (int j = index1; j >= 0; j--) {
					nums1[index1] = nums1[index1];
				}
				break;
			}
		}
	}
}
