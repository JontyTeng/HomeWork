package com.nanjing.three;

import java.util.Map;
import java.util.TreeMap;

public class Test14 {
	//取出一个字符串中字母出现的次数。如：字符串："abcdekka27qoq" ，
	 //* 输出格式为：a(2)b(1)k(2)...
	public static void main(String[] args) {
		String str = "abcdekka27qoq";
		char[] arr = str.toCharArray();
		//定义TreeMap集合，来存入字符及对应出现的次数
		TreeMap<Character,Integer> hs = new TreeMap<>();
		for (char c : arr) {
			/*Integer num = hs.get(c);
			if(num==null) {
				hs.put(c, 1);
			} else {
				hs.put(c, num+1);
			}*/	
			hs.put(c, (hs.get(c)==null?1:hs.get(c)+1));
		}
		System.out.println(hs);
		//将HashMap集合中的数据封装成a(2)b(1)k(2)...
		//利用StringBuilder完成字符串的拼装
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character,Integer> entry : hs.entrySet()) {
			//是字母的时候才拼接
			if(entry.getKey()>='a' && entry.getKey() <='z' || entry.getKey() >='A' && entry.getKey() <='Z'){
				sb.append(entry.getKey()).append("(").append(entry.getValue()).append(")");
			}
		}
		System.out.println(sb.toString());		
	}
}
