package com.nanjing.three;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test17 {
	//从键盘接受多个int型的整数,直到用户输入end结束
	// 要求:把所有的整数按倒序写到D:\\number.txt中

	public static void main(String[] args) throws Exception {
		//1.创建ArrayList集合
		ArrayList<Integer> list = new ArrayList<Integer>();
		//2.定义键盘录入对象
		Scanner sc = new Scanner(System.in);
		//3.循环录入数据，如果是end，结束录入
		while(true) {
			String str = sc.nextLine();
			//判断是否是"end"
			if("end".equals(str)) {
				break;
			}
			int thisNum;
			try {
				thisNum = Integer.parseInt(str);
				//将数字添加到集合中
				list.add(thisNum);
			} catch (Exception e) {
				System.out.println("输错了");
			}
			
		}
		//先反转集合中的内容
		Collections.reverse(list);
		//把list集合中的内容写入到文件中
		write2File(list);
	}
	
	//把list集合中的内容写入到文件中
	private static void write2File(ArrayList<Integer> list) throws Exception {
		FileWriter fw = new FileWriter("D:\\number.txt");
		for (Integer integer : list) {
			fw.write(integer + "");
		}
		fw.close();
	}
}