package easy;

/*
 * 2016.7.28
 * ʹ��һ�������¼���ֳ��ֵĴ�����
 * �ȱ���secret�����guess��Ӧλ����һ�������֣�a����������map�ж�Ӧ���ֳ��ֵĴ�����1
 * �ٱ���guess�����guess��secret��Ӧλ�ò���ȣ�ͬʱmap�ж�Ӧλ�õĳ��ִ�������0����b������Ȼ����ִ�����1
 */

public class Q299 {
	public String getHint(String secret, String guess) {
		int[] map = new int[10];
		int a = 0;
		int b = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				a++;
			} else {
				if (map[secret.charAt(i) - '0'] != 0) {
					map[secret.charAt(i) - '0']++;
				} else {
					map[secret.charAt(i) - '0'] = 1;
				}
			}
		}
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) != secret.charAt(i)) {
				if (map[guess.charAt(i) - '0'] > 0) {
					b++;
					map[guess.charAt(i) - '0']--;
				}
			}
		}
		return a + "A" + b + "B";
	}
}
