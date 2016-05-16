package medium;

import java.util.*;

public class Q79 {
	public boolean exist(char[][] board, String word) {
		HashSet<String> hashset = new HashSet<String>();
		char first = word.charAt(0);
		int m = board.length;
		int n = board[0].length;
		if (word.length() > m * n)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == first) {
					hashset.add(i + "," + j);
					if (ex(board, word, 1, i, j, 0, hashset))
						return true;
					hashset.remove(i + "," + j);
				}
			}
		}
		return false;
	}
	public boolean check(char[][] board, String word){
		HashMap<Character,Integer> b=new HashMap<Character,Integer>();
		HashMap<Character,Integer> s=new HashMap<Character,Integer>();
		
		return false;
	}
	public boolean ex(char[][] board, String word, int cur, int x, int y, int way, HashSet<String> hashset) {
		if (cur == word.length())
			return true;
		char next = word.charAt(cur);
		int m = board.length;
		int n = board[0].length;
		boolean res = false;
		for (int i = 1; i <= 4; i++) {
			if (i != way) {
				switch (i) {
				case 1:
					if (y - 1 >= 0 && board[x][y - 1] == next && !hashset.contains(x + "," + (y - 1))) {
						HashSet<String> copy = (HashSet<String>) hashset.clone();
						copy.add((x + "," + (y - 1)));
						res = res || ex(board, word, cur + 1, x, y - 1, 3, copy);
						if (res)
							return true;
					}
					break;
				case 2:
					if (x - 1 >= 0 && board[x - 1][y] == next && !hashset.contains((x - 1) + "," + y)) {
						HashSet<String> copy = (HashSet<String>) hashset.clone();
						copy.add(((x - 1) + "," + y));
						res = res || ex(board, word, cur + 1, x - 1, y, 4, copy);
						if (res)
							return true;
					}
					break;
				case 3:
					if (y + 1 < n && board[x][y + 1] == next && !hashset.contains(x + "," + (y + 1))) {
						HashSet<String> copy = (HashSet<String>) hashset.clone();
						copy.add((x + "," + (y + 1)));
						res = res || ex(board, word, cur + 1, x, y + 1, 1, copy);
						if (res)
							return true;
					}
					break;
				case 4:
					if (x + 1 < m && board[x + 1][y] == next && !hashset.contains((x + 1) + "," + y)) {
						HashSet<String> copy = (HashSet<String>) hashset.clone();
						copy.add(((x + 1) + "," + y));
						res = res || ex(board, word, cur + 1, x + 1, y, 2, copy);
						if (res)
							return true;
					}
					break;
				}
			}
		}
		return false;
	}
}
