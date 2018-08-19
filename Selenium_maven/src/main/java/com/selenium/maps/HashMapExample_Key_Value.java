package com.selenium.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample_Key_Value {

	public static void main(String[] args) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		map.put(1, 100);
		map.put(20, 300);
		map.put(4, 400);
		map.put(30, 200);
		map.put(6, 700);
		map.put(10, 900);
		map.put(null, 900);
		System.out.println(map.get(1));
		System.out.println(map.get(4));
		System.out.println(map.get(30));
		System.out.println(map.get(10));
		System.out.println(map.get(6));
		System.out.println(map.get(null));

	}

}
