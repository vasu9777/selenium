package com.selenium.maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap_Example {
/***
 * linked hash map maintain will maintain insertation order
 * @param args
 */
	public static void main(String[] args) {
		Map<Integer, Integer> map=new LinkedHashMap<Integer, Integer>();
		map.put(1, 100);
		map.put(20, 300);
		map.put(4, 400);
		map.put(30, 200);
		map.put(6, 700);
		map.put(10, 900);
		System.out.println(map);
	}

}
