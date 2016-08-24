import java.util.*;

import medium.*;
import easy.*;
import hard.*;
import extend.*;
import basicDataStructure.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long s=System.nanoTime();
		Q345 q=new Q345();
		q.reverseVowels("leetcode");
		long e=System.nanoTime();
		System.out.println((e-s)/1000000);
	}
}
