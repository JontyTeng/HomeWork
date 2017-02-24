package com.nanjing.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Test27 {
	// 一直数组int arr[] = {2,3,4,2,4}; (10分)
	// (1)计算出该数组的平均分、最大值、最小值
	// (2)并将大于平均分的元素放到当前根目录下number.txt中(以追加的方式添加)

	public static void main(String[] args) throws Exception {
		// 定义数组
		int arr[] = { 2, 3, 4, 2, 4 };
		// (1)计算出该数组的平均分、最大值、最小值
		int sum = 0;
		int max = arr[0];// 假设第0个元素是最大的
		int min = arr[0];// 假设第0个元素是最小的
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		// 计算平均分
		double avg = sum * 1.0 / arr.length;
		System.out
				.println("该数组的平均分:" + avg + " , 最大值:" + max + " , 最小值:" + min);
		// 将数组中的元素大于avg的写入到文件中
		writeArr2File(arr, avg);
		readFromFile();
	}

	// 将数组中的元素大于avg的写入到文件中
	private static void writeArr2File(int[] arr, double avg) throws Exception {
		/*
		 * //1.创建数据字节输出流对象 DataOutputStream dos = new DataOutputStream(new
		 * FileOutputStream("number.txt",true)); //2.遍历数组,将符合条件的元素写入到文件中 for
		 * (int i : arr) { if(i>avg) { dos.writeInt(i); } } //3.关闭流 dos.close();
		 */

		BufferedWriter bw = new BufferedWriter(new FileWriter("number.txt",
				true));
		for (int i : arr) {
			if (i > avg) {
				bw.write(i + "");
				bw.newLine();
			}
		}
		bw.close();

	}

	private static void readFromFile() throws Exception {
		/*
		 * //1.创建数组字节输入流对象 DataInputStream dis = new DataInputStream(new
		 * FileInputStream("number.txt")); int i = dis.readInt();
		 * System.out.println(i+" "); i = dis.readInt();
		 * System.out.println(i+" ");
		 */
		BufferedReader br = new BufferedReader(new FileReader("number.txt"));
		String line = null;
		while (null != (line = br.readLine())) {
			System.out.println(line);
		}
		br.close();
	}
}
