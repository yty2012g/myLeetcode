package easy;

/*
 * 2016.8.11
 * �����Ŀ����HashMap��Ӧ�á�
 * ʹ��һ��dict�����ʾ��ĸ��Ӧ��Ƶ�Ρ�
 * ��ͳ��magazine��ÿ����ĸ�����Ƶ�Ρ�
 * Ȼ��ransom�У�ÿ�γ���һ����ĸ����Ƶ��-1���������Ƶ��Ϊ�������򷵻�false��
 */
public class Q383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] dict = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			dict[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			dict[ransomNote.charAt(i) - 'a']--;
			if (dict[ransomNote.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}
}
