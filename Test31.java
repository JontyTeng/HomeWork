package com.nanjing.three;

import java.util.Scanner;

public class Test31 {
	// ģ����֤�ֻ��ŵĹ��̣���������Ҫ��ʵ����ش��루������ʾ����һ��Ҫ������
	// a. ��ʾ�û��ڿ���̨�����ֻ��ţ���һ���ַ���������б���
	// b. �жϸ��ֻ���λ���Ƿ���11λ
	// c. �жϸ��ֻ��ţ��Ƿ�������
	// d. �жϸ��ֻ������3Ϊ�����������ͬ��������Ϊ������

	public static void main(String[] args) {
		// a.��ʾ�û��ڿ���̨�����ֻ��ţ���һ���ַ���������б���
		// ��������¼�����
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ֻ���:");
		String phone = sc.nextLine();
		System.out.println("���,��������ֻ���Ϊ: " + phone);
		// b.�жϸ��ֻ���λ���Ƿ���11λ
		int len = phone.length();
		if (11 == len) {
			System.out.println("��������ֻ�����11λ");
		} else {
			System.out.println("��������ֻ��Ų���11λ");
		}
		if (isOrNotShuZi(phone)) {
			System.out.println("��������ֻ��Ŷ�������");
		} else {
			System.out.println("��������ֻ��Ű���������");
		}

		if (isLiangHao(phone)) {
			System.out.println("��������ֻ���������");
		} else {
			System.out.println("��������ֻ�������ͨ��");
		}

	}

	// �ж��ֻ������Ƿ���������ַ���
	public static boolean isOrNotShuZi(String phone) {
		/*
		 * //c.�жϸ��ֻ��ţ��Ƿ������� char[] chars = phone.toCharArray(); for (char c :
		 * chars) { if(!(c>='0'&&c<='9')) { //��һ����������,�ͷ���false return false; } }
		 * //�������ַ���true return true;
		 */
		String regex = "\\d{11}";
		return phone.matches(regex);
	}

	// d.�жϸ��ֻ������3Ϊ�����������ͬ��������Ϊ������
	public static boolean isLiangHao(String phone) {
		/*
		 * int len = phone.length(); phone = phone.substring(len-3);//13567 len
		 * = 5-3 char[] chars = phone.toCharArray();
		 * if(chars[0]==chars[1]&&chars[1]==chars[2]) { return true; } return
		 * false;
		 */
		String regex = "\\d{8}(\\d)\\1{2}";
		return phone.matches(regex);
	}
}
