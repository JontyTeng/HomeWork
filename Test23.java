package com.nanjing.three;

import java.util.Scanner;

public class Test23 {
	// 输入一个字符串,分别统计出其中英文字母、空格、数字和其它字符的数量

	public static void main(String[] args) {
		// 1.创建键盘录入对象,并获取控制台输入的字符串
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		String str = sc.nextLine();
		// 2.将字符串变成字符数组
		char[] arr = str.toCharArray();
		// 3.定义计数器
		int zmCount = 0;// 统计字母的计数器
		int sCount = 0;// 统计空格的计数器
		int dCount = 0;// 统计数字的计数器
		int oCount = 0;// 统计其它字符的计数器
		// 利用高级for循环遍历字符数组
		for (char c : arr) {
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				zmCount++;
			} else if (c == ' ' || c == '\t') {
				sCount++;
			} else if (c >= '0' && c <= '9') {
				dCount++;
			} else {
				oCount++;
			}
		}
		System.out.println("英文字母的数量为 " + zmCount + " 个,空格的数量为 " + sCount
				+ " 个,数字的数量为 " + dCount + " 个,其它符号的数量 " + oCount + " 个");
	}
}
