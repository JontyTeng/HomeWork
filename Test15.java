package com.nanjing.three;

import java.util.Scanner;

public class Test15 {
	// ��дһ��У���û����ĳ���,������¼����û����Ƿ�Ϸ�
	// Ҫ��:�û���������6-10λ֮�����ĸ���Ҳ��������ֿ�ͷ  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.nextLine();
		// ����������ʽ�������ж�
		String regex = "[A-Za-z][A-Za-z0-9]{5,9}";
		// ��������ַ�����������ʽ����ƥ��
		if (username.matches(regex)) {
			System.out.println("�û����Ϸ���");
		} else {
			System.out.println("�û����Ƿ���");
		}
	}
}