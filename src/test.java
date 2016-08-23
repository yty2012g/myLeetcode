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
		Q386 q=new Q386();
		q.lexicalOrder(5000000);
		long e=System.nanoTime();
		System.out.println((e-s)/1000000);
	}
}
