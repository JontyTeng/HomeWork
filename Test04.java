package com.nanjing.three;

import java.util.Scanner;

public class Test04 {
	// 1.设计一个程序,键盘输入月份,控制条输出季节.3,4,5春季/6,7,8夏季/9,10,11秋季/12,1,2冬季
	public static void main(String[] args) {

		// 1.创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		// 2.提示用户输入int类型的数据
		System.out.println("请输入一个1-12之间的整数:");
		// 3.接收用户输入的数字
		while (true) {
			String line = sc.nextLine();
			try {
				int monthNum = Integer.parseInt(line);
				String s = getSeason(monthNum);
				System.out.println(s);
				break;
			} catch (NumberFormatException e) {
				System.out.println("数字");
				continue;
			}
		}

	}

	private static String getSeason(int monthNum) {
		// 4.通过switch进行判断,并输出对应的月份
		switch (monthNum) {
		case 3:
		case 4:
		case 5:
			return "春季";
		case 6:
		case 7:
		case 8:
			return "夏季";
		case 9:
		case 10:
		case 11:
			return "秋季";
		case 12:
		case 1:
		case 2:
			return "冬季";
		default:
			return "对不起,您输入的月份有误...";
		}

	}
}
