package com.nanjing.three;

import java.util.HashMap;
import java.util.Map;

public class Test11 {

	// 2.现在有一个map集合如下:
	// {1="张三丰",2="周芷若",3="汪峰",4="灭绝师太"}
	// 要求:
	// 1.将map集合中的所有信息显示到控制台上
	// 2.向该map集合中插入一个编码为5姓名为李晓红的信息
	// 3.移除该map中的编号为1的信息
	// 4.将map集合中编号为2的姓名信息修改为"周林"

	public static void main(String[] args) {
		// 定义map集合，并存储数据
		HashMap<Integer, String> hs = new HashMap<Integer, String>();
		hs.put(1, "张三丰");
		hs.put(2, "周芷若");
		hs.put(3, "汪峰");
		hs.put(4, "灭绝师太");
		// 1.将map集合中的所有信息显示到控制台上
		for (Map.Entry<Integer, String> entry : hs.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		System.out.println("----------------");
		// 2.向该map集合中插入一个编码为5姓名为李晓红的信息
		hs.put(5, "李晓红");
		System.out.println(hs);
		// 3.移除该map中的编号为1的信息
		hs.remove(1);
		System.out.println(hs);
		// 4.将map集合中编号为2的姓名信息修改为"周林"
		// hs.put(2, "周琳");
		for (Map.Entry<Integer, String> entry : hs.entrySet()) {
			if (entry.getKey() == 2) {
				entry.setValue("周琳");
			}
		}
		System.out.println(hs);
	}
}
