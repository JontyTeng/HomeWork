package com.nanjing.three;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Test12 {
	// 将用户在控制台上输入5个数字，按照降序存入到“D：\\number.txt”中

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		System.out.println("请输入5个int类型的数据：");
		for (int i = 0; i < arr.length; ) {
			try {
				arr[i] = Integer.parseInt(sc.nextLine());
				i++;
			} catch (Exception e) {
				System.out.println("数字");
				continue;
			}
		}
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		// 因为排序后是从小到大，所以要想从打大到小的顺序写入到文件的话，只需要倒着遍历
		// 创建数据字节输出流对象
		FileWriter dos = new FileWriter("D:\\xx.txt");
		for (int i = arr.length - 1; i >= 0; i--) {
			dos.write(arr[i] + " ");
		}
		dos.close();
		BufferedReader br = new BufferedReader(new FileReader("D:\\xx.txt"));
		String readLine = br.readLine();
		System.out.println(readLine);
		br.close();
	}
}
