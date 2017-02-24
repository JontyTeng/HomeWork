package com.nanjing.three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Test32 {
	/*
	 * 在当前项目根目录下有一个“qq.txt文件”里面存放的内容如下：（14分） （项目根目录,假设qq号的长度最大为11位） 12345 67891
	 * 12347809933 98765432102 67891 12347809933 a.将该文件里面的所有qq号都存放在list中
	 * b.将list中重复元素删除 c.将剩余元素进行排序(按照长度由小到大) d.将list中所有元素用两种方式打印出来
	 */

	public static void main(String[] args) throws Exception {
		// a.将该文件里面的所有qq号都存放在list中
		// 创建字符缓冲输入流
		BufferedReader br = new BufferedReader(new FileReader("qq.txt"));
		String line = null;
		// 创建集合对象,存储QQ号
		ArrayList<String> list = new ArrayList<String>();
		while (null != (line = br.readLine())) {
			list.add(line);
		}
		// 关闭流对象
		br.close();
		System.out.println(list);
		// b.将list中重复元素删除
		// 根据LinkedHashSet的特性,可以完成去重,而且怎么存入就怎么取出
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		for (String str : list) {
			lhs.add(str);
		}
		// 清空list集合
		list.clear();
		// 将lhs集合中的元素添加到list中
		list.addAll(lhs);
		System.out.println(list);
		// c.将剩余元素进行排序(按照长度由小到大)
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int num = s1.length() - s2.length();
				return num == 0 ? 1 : num;
			}

		});
		for (String str : list) {
			ts.add(str);
		}
		System.out.println(ts);

		// d.将list中所有元素用两种方式打印出来
		// 1.利用高级for循环
		for (int i = 0; i < list.size(); i++) {
			String qq = list.get(i);
			if (i == list.size() - 1) {
				System.out.println(qq);

			} else {
				System.out.print(qq + ", ");
			}
		}
		System.out.println();
		// 2.利用迭代器
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
