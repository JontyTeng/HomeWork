package com.nanjing.three;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test05 {
	// 向list集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫替换为王小丫

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		// 1.创建List集合对象
		List<String> list = new ArrayList<>();
		// 2.存入数据
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("二丫");
		list.add("钱六");
		list.add("孙七");
		// 利用普通for循环遍历List集合
		for (int i = 0; i < list.size(); i++) {
			// 获取当前元素
			String thisName = list.get(i);
			// 如果当前元素是"二丫"
			if ("二丫".equals(thisName)) {
				// 将其改为"王小丫"
				list.set(i, "王小丫");
			}
		}
		System.out.println(list);
	}
}
