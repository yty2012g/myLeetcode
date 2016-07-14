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
		int[] nums={10,5,13,4,8,4,5,11,14,9,16,10,20,8};
		int ss=80;
		q.minSubArrayLen(ss, nums);
		
	}
}
