package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test19 {
	// 有一个Map集合里面存储的是学生的姓名和年龄，内容如下{张三丰=21, 灭绝师太=38, 柳岩=28, 刘德华=40, 老鬼=36,
	// 王二麻子=38}
	// a.将里面的元素用两种遍历方式打印到控制台上
	// b.将老鬼的年龄改成66
	// c.将年龄大于24的学生姓名，存入到D:\\student.txt中

	public static void main(String[] args) throws Exception {
		// 定义一个TreeMap集合,并存入数据
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("张三丰", 21);
		tm.put("灭绝师太", 38);
		tm.put("柳岩", 28);
		tm.put("刘德华", 40);
		tm.put("老鬼", 36);
		tm.put("王二麻子", 38);
		// 将里面的元素用两种遍历方式打印到控制台上
		// 利用迭代器获取所有的key,通过遍历key,获取对应的value
		Set<String> set = tm.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = tm.get(key);
			System.out.println(key + "=" + value);
		}
		System.out.println("---------------");
		Set<Map.Entry<String, Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<String, Integer>> it2 = entrySet.iterator();
		while (it2.hasNext()) {
			Map.Entry<String, Integer> entry = it2.next();
			/*
			 * if("老鬼".equals(entry.getKey())) { entry.setValue(88); }
			 */
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
		System.out.println("===================");
		// b.将老鬼的年龄改成66
		tm.put("老鬼", 66);
		System.out.println(tm);
		// c.将年龄大于24的学生姓名，存入到D:\\student.txt中
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("D:\\student.txt"));
		for (Map.Entry<String, Integer> entry : tm.entrySet()) {
			if (entry.getValue() > 24) {
				// 将对应的学生姓名写入到文件
				bw.write(entry.getKey());
				bw.newLine();
			}
		}
		bw.close();
		

	}
}
