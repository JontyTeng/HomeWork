package com.nanjing.three;

import java.util.Scanner;

public class Test23 {
	// ����һ���ַ���,�ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ�������

	public static void main(String[] args) {
		// 1.��������¼�����,����ȡ����̨������ַ���
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ���:");
		String str = sc.nextLine();
		// 2.���ַ�������ַ�����
		char[] arr = str.toCharArray();
		// 3.���������
		int zmCount = 0;// ͳ����ĸ�ļ�����
		int sCount = 0;// ͳ�ƿո�ļ�����
		int dCount = 0;// ͳ�����ֵļ�����
		int oCount = 0;// ͳ�������ַ��ļ�����
		// ���ø߼�forѭ�������ַ�����
		for (char c : arr) {
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				zmCount++;
			} else if (c == ' ' || c == '\t') {
				sCount++;
			} else if (c >= '0' && c <= '9') {
				dCount++;
			} else {
				oCount++;
			}
		}
		System.out.println("Ӣ����ĸ������Ϊ " + zmCount + " ��,�ո������Ϊ " + sCount
				+ " ��,���ֵ�����Ϊ " + dCount + " ��,�������ŵ����� " + oCount + " ��");
	}
}
