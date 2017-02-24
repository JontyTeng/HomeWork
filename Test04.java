package com.nanjing.three;

import java.util.Scanner;

public class Test04 {
	// 1.���һ������,���������·�,�������������.3,4,5����/6,7,8�ļ�/9,10,11�＾/12,1,2����
	public static void main(String[] args) {

		// 1.��������¼�����
		Scanner sc = new Scanner(System.in);
		// 2.��ʾ�û�����int���͵�����
		System.out.println("������һ��1-12֮�������:");
		// 3.�����û����������
		while (true) {
			String line = sc.nextLine();
			try {
				int monthNum = Integer.parseInt(line);
				String s = getSeason(monthNum);
				System.out.println(s);
				break;
			} catch (NumberFormatException e) {
				System.out.println("����");
				continue;
			}
		}

	}

	private static String getSeason(int monthNum) {
		// 4.ͨ��switch�����ж�,�������Ӧ���·�
		switch (monthNum) {
		case 3:
		case 4:
		case 5:
			return "����";
		case 6:
		case 7:
		case 8:
			return "�ļ�";
		case 9:
		case 10:
		case 11:
			return "�＾";
		case 12:
		case 1:
		case 2:
			return "����";
		default:
			return "�Բ���,��������·�����...";
		}

	}
}
