package easy;

/*
 * 2016.7.28
 * 使用一个数组记录数字出现的次数。
 * 先遍历secret，如果guess对应位置是一样的数字，a自增。否则，map中对应数字出现的次数加1
 * 再遍历guess，如果guess和secret对应位置不想等，同时map中对应位置的出现次数大于0，则b自增，然后出现次数减1
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
