package com.selenium.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap m=new HashMap();
		m.put(101, "geetha");
		m.put(102, "seetha");
		m.put(103, "haritha");
		m.put(104, "samatha");
		System.out.println(m);
		System.out.println(m.putIfAbsent(101, "reshmi"));
		Set s=m.keySet();
		System.out.println(s);
		Collection c=m.values();
		System.out.println(c);
		Set s1=m.entrySet();
		System.out.println(s1);
	}

}
