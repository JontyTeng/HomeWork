package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws IOException {
		/*
		 * 1.键盘输入10个数，放到数组中 a. 去除该数组中大于10的数 b. 将该数组中的数字写入到本地文件number.txt中
		 */
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		int index = 0;
		while (index < 10) {
			if (sc.hasNextInt()) {
				arr[index] = sc.nextInt();
				index++;
			}else{
				sc.nextLine();
				System.out.println("输错了");
			}
		}
		//统计小于等于10的
		//这里也可以直接在存入的时候就判断
		int count = 0 ;
		for (int i : arr) {
			if(i<=10){
				count++;
			}
		}
		int [] arr2 = new int [count];
		count = 0;//将计数器变成0
		for (int i : arr) {
			if(i<=10){
				arr2[count] = i;
				count++;
			}
		}
		System.out.println(Arrays.toString(arr2));
		BufferedWriter bw = new BufferedWriter(new FileWriter("number.txt"));
		bw.write(Arrays.toString(arr2));
		bw.close();
	}
}
