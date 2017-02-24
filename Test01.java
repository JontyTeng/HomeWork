package com.nanjing.three;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Test01 {
	public static void main(String[] args) {
		/*
		 * 将"zhang wei zhen shuai zhang wei fei chang shuai"每个单词的首字母转换成大写其余还是小写字母
		 * (不许直接输出Zhang Wei Zhen Shuai Zhang Wei Fei Chang Shuai要用代码实现)
		 * (1)正常写法，什么方法都可以使用 （2）不允许使用toUpperCase() 和toLowerCase() 的方法
		 */
		String s = "ZhAng Wei zhEn shuAi Zhang wei fei chang shuai";
		String[] strings = s.split(" ");

		/*
		 * StringBuffer ss = new StringBuffer(); for (String string : strings) {
		 * String concat = string.substring(0, 1).toUpperCase()
		 * .concat(string.substring(1).toLowerCase());
		 * ss.append(concat).append(" "); }
		 * System.out.println(ss.toString().trim());
		 */

		//StringBuilder sss = new StringBuilder(); // 不用方法
		//for (int i = 0; i < strings.length; i++) {
		//	String string = strings[i];// string 表示每一个小串
		//	char firstChar = changeUp(string.charAt(0));// 首字母
		//	sss.append(firstChar);
		//	for (int j = 1; j < string.length(); j++) {//
				// 遍历每一个小串
		//		sss.append(changeLow(string.charAt(j)));
		//	}
		//	sss.append(" ");
	//	}

	//	System.out.println(sss.toString().trim());

		// 第三种解法
		StringBuffer ss = new StringBuffer();
		for (String string : strings) {
			String first = string.substring(0, 1);
			String behind = string.substring(1);

			String newString = changeUp(first) + changeLow(behind);
			ss.append(newString).append(" ");
		}
		System.out.println(ss.toString().trim());
	}

	private static char changeLow(char c) {
		if (c >= 'a' && c <= 'z') {
			return c;
		} else if (c <= 'Z' && c >= 'A') {
			return (char) (c + 32);
		} else {
			return '\u0000';// char初始化值
		}
	}

	private static String changeLow(String c) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < c.length(); i++) {
			char low = changeLow(c.charAt(i));
			s.append(low);
		}
		return s.toString();
	}

	private static char changeUp(char c) {
		if (c >= 'a' && c <= 'z') {
			return (char) (c - 32);
		} else if (c <= 'Z' && c >= 'A') {
			return c;
		} else {
			return '\u0000';// char初始化值
		}

	}

	private static String changeUp(String c) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < c.length(); i++) {
			char up = changeUp(c.charAt(i));
			s.append(up);
		}
		return s.toString();
	}
}
