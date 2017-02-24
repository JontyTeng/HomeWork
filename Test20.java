package com.nanjing.three;

public class Test20 {
	//有一个字符串"woaijavahahajavaaiwo"删除该字符串中所有的"java"并且统计删除了多少个“java”

	public static void main(String[] args) {
		//demo1();	//第一种解法
		String max = "woaijavahahajavaaiwo";
		String min = "java";
		String newString = max.replaceAll("java", "");
		System.out.println(newString);
		System.out.println((max.length() - newString.length())/min.length());
 	}

	private static void demo1() {
		String str = "woaijavahahajavaaiwo";
		int count = 0;
		while(-1!=str.indexOf("java")) {
			//进行替换的操作
			str = str.replaceFirst("java", "");
			count++;
		}
		System.out.println(str);
		System.out.println("总共删除了 "+count+" 个java");
	}
}
