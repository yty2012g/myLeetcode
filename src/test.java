import java.util.*;

import medium.*;
import easy.*;
import hard.*;
import extend.*;
import basicDataStructure.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q345 q = new Q345();
		HashMap<String, Integer> map = new HashMap<>();
		String a = "ab";
		String b = "ab";
		map.put(a, 1);
		map.put(b, 2);
		System.out.println(a.hashCode() + "  " + b.hashCode());
	}
}
