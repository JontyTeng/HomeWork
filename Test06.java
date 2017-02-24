package com.nanjing.three;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test06 {
	// 从键盘输入一个值,根据值进行判断如果是小于60则输出sorry,如果是包含60分以上则输出ok

	public static void main(String[] args) throws Exception {
		// 创建键盘录入对象
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 读取用户输入的数字字符串
		String line = br.readLine();
		// 将字符创转换成int类型的数据
		int number;
		try {
			number = Integer.parseInt(line);
			if (number < 60) {
				System.out.println("sorry");
			} else {
				System.out.println("ok");
			}
		} catch (Exception e) {
			System.out.println("输入有误");
		}
		
	}
}
