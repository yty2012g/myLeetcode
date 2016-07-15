import java.util.*;

import medium.*;
import easy.*;
import hard.*;
import extend.*;
import basicDataStructure.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] t = { "..4....3.", ".63.....2", "89.1.....", "..8.72...", "...846...", "...93.5..", ".....5.16",
				"1.....85.", ".5....3.." };
		char[][] s = { t[0].toCharArray(), t[1].toCharArray(), t[2].toCharArray(), t[3].toCharArray(),
				t[4].toCharArray(), t[5].toCharArray(), t[6].toCharArray(), t[7].toCharArray(), t[8].toCharArray() };
		Q209 q = new Q209();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(2, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				if (arg0 > arg1)
					return -1;
				else
					return 1;
			}

		});
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		pq.offer(4);
		pq.offer(5);
		System.out.println(pq);
	}
}
