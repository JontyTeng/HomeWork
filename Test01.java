package com.nanjing.three;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Test01 {
	public static void main(String[] args) {
		/*
		 * ��"zhang wei zhen shuai zhang wei fei chang shuai"ÿ�����ʵ�����ĸת���ɴ�д���໹��Сд��ĸ
		 * (����ֱ�����Zhang Wei Zhen Shuai Zhang Wei Fei Chang ShuaiҪ�ô���ʵ��)
		 * (1)����д����ʲô����������ʹ�� ��2��������ʹ��toUpperCase() ��toLowerCase() �ķ���
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

		//StringBuilder sss = new StringBuilder(); // ���÷���
		//for (int i = 0; i < strings.length; i++) {
		//	String string = strings[i];// string ��ʾÿһ��С��
		//	char firstChar = changeUp(string.charAt(0));// ����ĸ
		//	sss.append(firstChar);
		//	for (int j = 1; j < string.length(); j++) {//
				// ����ÿһ��С��
		//		sss.append(changeLow(string.charAt(j)));
		//	}
		//	sss.append(" ");
	//	}

	//	System.out.println(sss.toString().trim());

		// �����ֽⷨ
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
			return '\u0000';// char��ʼ��ֵ
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
			return '\u0000';// char��ʼ��ֵ
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
