package com.nanjing.three;

import java.util.Scanner;

public class Test15 {
	// 编写一个校验用户名的程序,检测键盘录入的用户名是否合法
	// 要求:用户名必须是6-10位之间的字母并且不能以数字开头  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		// 利用正则表达式，进行判断
		String regex = "[A-Za-z][A-Za-z0-9]{5,9}";
		// 将输入的字符串与正则表达式进行匹配
		if (username.matches(regex)) {
			System.out.println("用户名合法！");
		} else {
			System.out.println("用户名非法！");
		}
	}
}