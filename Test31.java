package com.nanjing.three;

import java.util.Scanner;

public class Test31 {
	// 模拟验证手机号的过程，按照以下要求实现相关代码（友情提示：不一定要用正则）
	// a. 提示用户在控制台输入手机号，用一个字符串对其进行保存
	// b. 判断该手机号位数是否是11位
	// c. 判断该手机号，是否都是数字
	// d. 判断改手机号最后3为数字如果是相同数字则认为是靓号

	public static void main(String[] args) {
		// a.提示用户在控制台输入手机号，用一个字符串对其进行保存
		// 创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入手机号:");
		String phone = sc.nextLine();
		System.out.println("你好,你输入的手机号为: " + phone);
		// b.判断该手机号位数是否是11位
		int len = phone.length();
		if (11 == len) {
			System.out.println("您输入的手机号是11位");
		} else {
			System.out.println("您输入的手机号不是11位");
		}
		if (isOrNotShuZi(phone)) {
			System.out.println("您输入的手机号都是数字");
		} else {
			System.out.println("您输入的手机号包含非数字");
		}

		if (isLiangHao(phone)) {
			System.out.println("您输入的手机号是靓号");
		} else {
			System.out.println("您输入的手机号是普通号");
		}

	}

	// 判断手机号中是否包含非数字符号
	public static boolean isOrNotShuZi(String phone) {
		/*
		 * //c.判断该手机号，是否都是数字 char[] chars = phone.toCharArray(); for (char c :
		 * chars) { if(!(c>='0'&&c<='9')) { //有一个不是数字,就返回false return false; } }
		 * //都是数字返回true return true;
		 */
		String regex = "\\d{11}";
		return phone.matches(regex);
	}

	// d.判断该手机号最后3为数字如果是相同数字则认为是靓号
	public static boolean isLiangHao(String phone) {
		/*
		 * int len = phone.length(); phone = phone.substring(len-3);//13567 len
		 * = 5-3 char[] chars = phone.toCharArray();
		 * if(chars[0]==chars[1]&&chars[1]==chars[2]) { return true; } return
		 * false;
		 */
		String regex = "\\d{8}(\\d)\\1{2}";
		return phone.matches(regex);
	}
}
