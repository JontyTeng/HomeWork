package com.nanjing.three;

public class Test20 {
	//��һ���ַ���"woaijavahahajavaaiwo"ɾ�����ַ��������е�"java"����ͳ��ɾ���˶��ٸ���java��

	public static void main(String[] args) {
		//demo1();	//��һ�ֽⷨ
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
			//�����滻�Ĳ���
			str = str.replaceFirst("java", "");
			count++;
		}
		System.out.println(str);
		System.out.println("�ܹ�ɾ���� "+count+" ��java");
	}
}
