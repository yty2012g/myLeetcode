package hard;
/*
 * 2016.5.1
 * ��򵥵ķ���������merge sort������������������merge���ҵ��ڣ�m+n��/2�������õ���λ����ʱ�临�Ӷ�ΪO(n/2);
 * �߼��ķ�����ʹ�ö���������˼�롣������λ�����ȼ۱任����ڣ�m+n��/2С������
 * ��ʱ����������kС������
 * ���ȣ���k�ֳɾ��ֳ����ݣ���a��b���������м��㣬�����С������װ����k/2������������Ϊȫ�������֣��ϴ������ֵ�ʣ�µ����֡�
 * ���裬a����ֵ���pa����b����ֵ���k-pa��
 * ���a[as+pa-1]<b[bs+pb-1],˵����a�е�pa�����ںϲ��Ĵ������ж���С�ڵ�kС�����ģ���ȫ��������
 * �����ȣ���˵��a[as+pa-1]��������ĵ�kС������
 * �����֮����˵��b�е�pb����ȫ��������
 * ֹͣ������������1��С�����Ѿ�ȫ�������ˣ����kС����Ϊb[bs+k-1]
 *            ����2��k�����1����ѡȡa��b�е�һ����С��Ԫ�ء�
 *            
 * ����ʱ�临�Ӷ�ΪO(log(k)),Ҳ����O(log((m+n)/2))
 * ����λ�����ֳ����������������Ϊ����������Ϊ�ڣ�m+n��/2+1�����֣�����Ϊ�ڣ�m+n��/2�����ֺ͵ڣ�m+n��/2+1�����ֵ�ƽ������
 */
public class Q4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0)
			return 0;
		if (nums1.length == 0)
			return nums2.length % 2 == 0 ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2
					: nums2[nums2.length / 2];
		if (nums2.length == 0)
			return nums1.length % 2 == 0 ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2
					: nums1[nums1.length / 2];
		boolean flag = true;
		if ((nums1.length + nums2.length) % 2 == 0)
			flag = true;
		else
			flag = false;
		int num = 0;
		int f1 = 0;
		int f2 = 0;
		int res1 = 0;
		int res2 = 0;
		for (int i = 0; i < nums1.length + nums2.length; i++) {
			if (f1 < nums1.length && f2 < nums2.length) {
				if (flag == false && num == (nums1.length + nums2.length) / 2)
					return nums1[f1] < nums2[f2] ? nums1[f1] : nums2[f2];
				if (flag == true && num == (nums1.length + nums2.length) / 2 - 1)
					res1 = nums1[f1] < nums2[f2] ? nums1[f1] : nums2[f2];
				if (flag == true && num == (nums1.length + nums2.length) / 2) {
					res2 = nums1[f1] < nums2[f2] ? nums1[f1] : nums2[f2];
					break;
				}
				if (nums1[f1] < nums2[f2])
					f1++;
				else
					f2++;
				num++;

			} else if (f1 < nums1.length) {
				if (flag == false && num == (nums1.length + nums2.length) / 2)
					return nums1[f1];
				if (flag == true && num == (nums1.length + nums2.length) / 2 - 1)
					res1 = nums1[f1];
				if (flag == true && num == (nums1.length + nums2.length) / 2) {
					res2 = nums1[f1];
					break;
				}
				f1++;
				num++;
			} else {
				if (flag == false && num == (nums1.length + nums2.length) / 2)
					return nums2[f2];
				if (flag == true && num == (nums1.length + nums2.length) / 2 - 1)
					res1 = nums2[f2];
				if (flag == true && num == (nums1.length + nums2.length) / 2) {
					res2 = nums2[f2];
					break;
				}
				f2++;
				num++;
			}
		}
		return ((double) res1 + (double) res2) / 2;
	}

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		if (total % 2 == 0) {
			return (findK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2)
					+ findK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1)) / 2;
		} else
			return findK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1);
	}

	public double findK(int[] a, int as, int ae, int[] b, int bs, int be, int k) {
		int m = ae - as + 1;
		int n = be - bs + 1;
		if (m > n)
			return findK(b, bs, be, a, as, ae, k);
		if (m == 0)
			return b[bs + k - 1];
		if (k == 1)
			return Math.min(a[as], b[bs]);
		int pa = Math.min(k / 2, m);
		int pb = k - pa;
		if (a[as + pa - 1] < b[bs + pb - 1]) {
			return findK(a, as + pa, ae, b, bs, be, k - pa);
		} else if (a[as + pa - 1] > b[bs + pb - 1]) {
			return findK(a, as, ae, b, bs + pb, be, k - pb);
		} else {
			return a[as + pa - 1];
		}
	}
}
