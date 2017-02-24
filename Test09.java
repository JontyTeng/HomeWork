package com.nanjing.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test09 {
	/*
	 * 给定一个list集合:{"张柏芝","刘德华","张亮","张靓颖","杨颖","黄晓明"}
	 * 1.编写一个方法:将list集合中所有姓张的人员写入到D:\\a.txt中
	 * 2.编写一个方法:将D:\\a.txt中所有姓张的人员信息读取出来并打印到控制台上
	 */
	// 创建list集合
	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<>();
		// 存入数据
		list.add("张柏芝");
		list.add("刘德华");
		list.add("张亮");
		list.add("张靓颖");
		list.add("杨颖");
		list.add("黄晓明");
		// 遍历list集合，将符合条件的数据写入到文件中
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\a.txt"));
		for (String thisName : list) {
			if (thisName.startsWith("张")) {
				bw.write(thisName);
				bw.newLine();
			}
		}
		bw.close();
		// 从文件读取内容
		BufferedReader br = new BufferedReader(new FileReader("D:\\a.txt"));
		String line = null;
		while (null != (line = br.readLine())) {
			System.out.println(line);
		}
		br.close();
	}
}
