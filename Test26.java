package com.nanjing.three;

import java.util.Arrays;
import java.util.Scanner;

public class Test26 {
	/*
	 * �ӿ���̨����һ���ַ���(8��) (1)�����ַ���ת�����ַ�����(2��) (2)�����ַ������±�Ϊż�����ַ���ӡ������̨(3��)
	 * (3)�����ַ�����ĵ�һ��Ԫ�������һ��Ԫ�ػ���(3��)
	 */

	public static void main(String[] args) {
		// 1.��������¼�����
		Scanner sc = new Scanner(System.in);
		/*
		 * InputStream in = System.in; Reader r = new InputStreamReader(in);
		 * BufferedReader br = new BufferedReader(r); BufferedReader br = new
		 * BufferedReader(new InputStreamReader(System.in));
		 */
		System.out.println("������һ���ַ���:");
		// �����û�������ַ���
		String str = sc.nextLine();
		// 2.�����ַ���ת�����ַ�����
		char[] arr = str.toCharArray();// ctrl+2 ->L
		// 3.�����ַ������±�Ϊż�����ַ���ӡ������̨
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				System.out.println(arr[i]);
			}
		}
		// 4.�����ַ�����ĵ�һ��Ԫ�������һ��Ԫ�ػ���
		// ��һ�ַ���,���õ���������ʵ��
		char temp = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;
		// ����Arrays.toString()����ӡ����
		System.out.println(Arrays.toString(arr));

		int a = 20, b = 30;
		/*
		 * a = a+b;//20+30=50 b = a-b;//b = 50-30 = 20 a = a-b;//50-20 = 30
		 */
		a = a ^ b;// a = 20^30
		b = a ^ b;// b = 20^30^30 = 20
		a = a ^ b;// a = 20^30^20
		System.out.println("a=" + a + ",b=" + b);
	}
}
