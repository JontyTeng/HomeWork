package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Test30 {
	// 有一个数组 String arr[]={"abc","bad","abc","aab","bad","cef","jhi"};
	// a. 创建一个ArrayList，将数组里面的元素添加进去，但元素不能重复 (该数组不变)
	// b. 创建一个 TreeSet，将数组里面的元素按升序序存入该集合里，并且不能去重
	// c. 将数组里面的所有元素存入到项目根目录下的String.txt文件中

	public static void main(String[] args) throws Exception {
		// 定义数组
		String arr[] = { "abc", "bad", "abc", "aab", "bad", "cef", "jhi" };
		// a.创建一个ArrayList，将数组里面的元素添加进去，但元素不能重复 (该数组不变)
		ArrayList<String> list = new ArrayList<>();
		for (String str : arr) {
			if (!list.contains(str))
				list.add(str);
		}
		System.out.println(list);
		// b.创建一个 TreeSet，将数组里面的元素按升序序存入该集合里，并且不能去重
		// 创建TreeSet集合，并传入一个比较器
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int num = s1.compareTo(s2);
				return num == 0 ? 1 : num;
			}

		});
		// 遍历数组arr,将元素添加到ts集合中
		for (String str : arr) {
			ts.add(str);
		}
		System.out.println(ts);
		// c.将数组里面的所有元素存入到项目根目录下的String.txt文件中
		BufferedWriter bw = new BufferedWriter(new FileWriter("String.txt"));
		for (String str : arr) {
			bw.write(str);
			bw.newLine();
		}
		bw.close();
		// a,b,c,d,e 3 abc dec
		FileReader fr = new FileReader("String.txt");
		char[] chars = new char[1024 * 8];
		int len = -1;
		while (-1 != (len = fr.read(chars))) {
			System.out.println(new String(chars, 0, len));
		}
	}
}
