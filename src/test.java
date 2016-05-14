import java.util.*;

import medium.*;
import easy.*;
import hard.*;
import extend.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] t = { "..4....3.", ".63.....2", "89.1.....", "..8.72...", "...846...", "...93.5..", ".....5.16",
				"1.....85.", ".5....3.." };
		char[][] s = { t[0].toCharArray(), t[1].toCharArray(), t[2].toCharArray(), t[3].toCharArray(),
				t[4].toCharArray(), t[5].toCharArray(), t[6].toCharArray(), t[7].toCharArray(), t[8].toCharArray() };
		Q51 q = new Q51();
		int[] test = new int[25000];
		for (int i = 0; i < test.length; i++) {
			test[i] = 1;
		}
		String[] r={"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(q.solveNQueens(3));
	}
}
