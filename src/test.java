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
		Q297 q = new Q297();
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		t1.left=t2;
		t1.right=t3;
		t3.left=t4;
		t3.right=t5;
		System.out.println(q.serialize(t1));

	}
}
