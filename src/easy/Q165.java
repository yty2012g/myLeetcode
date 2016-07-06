package easy;

/*
 * 2016.7.6
 * �����Ŀ����������String���split��������version�ָ
 *             **ע��**
 *        split��������Ĳ�����������ʽ�����������.�Ļ���Ҫ����ת��
 * �����ͱȽϳ����ˡ��ҵ��Ƚϳ����Ǹ���ÿһ�����ֽ��бȽϡ�
 */
public class Q165 {
	public int compareVersion(String version1, String version2) {
		String[] one = version1.split("\\.");
		String[] two = version2.split("\\.");
		if (one.length > two.length) {
			for (int i = 0; i < one.length; i++) {
				int a = Integer.parseInt(one[i]);
				int b = i < two.length ? Integer.parseInt(two[i]) : 0;
				if (a > b)
					return 1;
				else if (b > a)
					return -1;
			}
		} else {
			for (int i = 0; i < two.length; i++) {
				int b = Integer.parseInt(two[i]);
				int a = i < one.length ? Integer.parseInt(one[i]) : 0;
				if (a > b)
					return 1;
				else if (b > a)
					return -1;
			}
		}
		return 0;
	}
}
