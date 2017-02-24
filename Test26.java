package com.nanjing.three;

import java.util.Arrays;
import java.util.Scanner;

public class Test26 {
	/*
	 * 从控制台接受一串字符串(8分) (1)将该字符串转换成字符数组(2分) (2)将该字符数组下标为偶数的字符打印倒控制台(3分)
	 * (3)将该字符数组的第一个元素与最后一个元素互换(3分)
	 */

	public static void main(String[] args) {
		// 1.创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		/*
		 * InputStream in = System.in; Reader r = new InputStreamReader(in);
		 * BufferedReader br = new BufferedReader(r); BufferedReader br = new
		 * BufferedReader(new InputStreamReader(System.in));
		 */
		System.out.println("请输入一个字符串:");
		// 接收用户输入的字符串
		String str = sc.nextLine();
		// 2.将该字符串转换成字符数组
		char[] arr = str.toCharArray();// ctrl+2 ->L
		// 3.将该字符数组下标为偶数的字符打印到控制台
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				System.out.println(arr[i]);
			}
		}
		// 4.将该字符数组的第一个元素与最后一个元素互换
		// 第一种方法,利用第三方变量实现
		char temp = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;
		// 利用Arrays.toString()来打印数组
		System.out.println(Arrays.toString(arr));

		int a = 20, b = 30;
		/*
		 * a = a+b;//20+30=50 b = a-b;//b = 50-30 = 20 a = a-b;//50-20 = 30
		 */
		a = a ^ b;// a = 20^30
		b = a ^ b;// b = 20^30^30 = 20
		a = a ^ b;// a = 20^30^20
		System.out.println("a=" + a + ",b=" + b);
	}
}
