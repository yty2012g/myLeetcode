package hard;

import java.util.*;

public class Q37 {
	public HashMap<String, LinkedList<Character>> map;
	public TreeMap<String, LinkedList<Character>> tmap;

	public void solveSudoku(char[][] board) {
		map = new HashMap<String, LinkedList<Character>>();
		tmap = new TreeMap<String, LinkedList<Character>>();
		LinkedList<Character> list = new LinkedList<Character>();
		for (char i = '1'; i <= '9'; i++)
			list.add(i);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					LinkedList<Character> copy = (LinkedList<Character>) list.clone();
					for (int a = 0; a < 9; a++) {
						if (board[a][j] != '.')
							copy.remove((Character) board[a][j]);
						if (board[i][a] != '.')
							copy.remove((Character) board[i][a]);
					}
					int startH = i / 3 * 3;
					int startL = j / 3 * 3;
					for (int a = startH; a < startH + 3; a++) {
						for (int b = startL; b < startL + 3; b++) {
							if (board[a][b] != '.')
								copy.remove((Character) board[a][b]);
						}
					}
					String mapKey = i + "," + j;
					String tmapKey = copy.size() + "," + i + "," + j;
					map.put(mapKey, copy);
					tmap.put(tmapKey, copy);
				}
			}
		}
		while (tmap.size() != 0) {
			boolean flag = true;
			Iterator iter = tmap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String k = (String) entry.getKey();
				LinkedList<Character> v = (LinkedList<Character>) entry.getValue();
				String[] res = k.split(",");
				int num = Integer.parseInt(res[0]);
				int x = Integer.parseInt(res[1]);
				int y = Integer.parseInt(res[2]);
				if (num != 1)
					break;
				flag = false;
				board[x][y] = v.get(0);
				map.remove(x + "," + y);
				for (int a = 0; a < 9; a++) {
					if (board[a][y] == '.') {
						String mk = a + "," + y;
						map.get(mk).remove((Character) v.get(0));
					}
					if (board[x][a] == '.') {
						String mk = x + "," + a;
						map.get(mk).remove((Character) v.get(0));
					}
					int startH = x / 3 * 3;
					int startL = y / 3 * 3;
					for (int i = startH; i < startH + 3; i++) {
						for (int j = startL; j < startL + 3; j++) {
							if (board[i][j] == '.')
								map.get(i + "," + j).remove((Character) v.get(0));
						}
					}
				}
			}
			if (flag)
				break;
			tmap.clear();
			Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String k = (String) entry.getKey();
				LinkedList<Character> v = (LinkedList<Character>) entry.getValue();
				String tk = v.size() + "," + k;
				tmap.put(tk, v);
			}

			//System.out.println();
		}
		TreeMap<String, LinkedList<Character>> tcopy = new TreeMap<String, LinkedList<Character>>();
		HashMap<String, LinkedList<Character>> copy = new HashMap<String, LinkedList<Character>>();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			LinkedList<Character> v = (LinkedList<Character>) entry.getValue();
			v = (LinkedList<Character>) v.clone();
			String tk = v.size() + "," + k;
			tcopy.put(tk, v);
			copy.put(k, v);
		}
		printtmap(tmap);
		print(board);
		//solve(board,tcopy,copy);
	}

	public boolean solve(char[][] board, TreeMap<String, LinkedList<Character>> tm,
			HashMap<String, LinkedList<Character>> m) {
//		char[][] copyboard=board.clone();
//		TreeMap<String, LinkedList<Character>> tcopy = new TreeMap<String, LinkedList<Character>>();
//		HashMap<String, LinkedList<Character>> copy = new HashMap<String, LinkedList<Character>>();
//		Iterator it = m.entrySet().iterator();
//		while (it.hasNext()) {
//			Map.Entry entry = (Map.Entry) it.next();
//			String k = (String) entry.getKey();
//			LinkedList<Character> v = (LinkedList<Character>) entry.getValue();
//			if(v.size()==0) return false;
//			v = (LinkedList<Character>) v.clone();
//			String tk = v.size() + "," + k;
//			tcopy.put(tk, v);
//			copy.put(k, v);
//		}
//		Iterator iter = tcopy.entrySet().iterator();
//		Map.Entry entry = (Map.Entry) iter.next();
//		String k = (String) entry.getKey();
//		LinkedList<Character> v = (LinkedList<Character>) entry.getValue();
//		String[] res = k.split(",");
//		int num = Integer.parseInt(res[0]);
//		int x = Integer.parseInt(res[1]);
//		int y = Integer.parseInt(res[2]);
		return false;
	}

	public void print(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.')
					System.out.print(board[i][j]);
				else
					System.out.print('_');
			}
			System.out.println();
		}
	}

	public void printmap(HashMap<String, LinkedList<Character>> map) {
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String k = (String) entry.getKey();
			LinkedList<Character> v = (LinkedList<Character>) entry.getValue();
			System.out.print(k + "   ");
			for (int i = 0; i < v.size(); i++) {
				System.out.print(v.get(i) + ",");
			}
			System.out.println();
		}
	}

	public void printtmap(TreeMap<String, LinkedList<Character>> map) {
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String k = (String) entry.getKey();
			LinkedList<Character> v = (LinkedList<Character>) entry.getValue();
			System.out.print(k + "   ");
			for (int i = 0; i < v.size(); i++) {
				System.out.print(v.get(i) + ",");
			}
			System.out.println();
		}
	}
}
