package com.nanjing.three;

import java.util.Arrays;
import java.util.Random;

public class qwdqwdqwd {
	// .ĳ��˾��֯���,�����볡ʱ���������,���볡ʱÿλԱ�����ܻ�ȡһ��˫ɫ���Ʊ,���蹫˾��100��Ա��,���ö�
	// �߳�ģ������볡����,
	// ���ֱ�ͳ��ÿ������볡������,�Լ�ÿ��Ա���õ��Ĳ�Ʊ�ĺ��롣�߳����к��ӡ��ʽ���£�
	// ���Ϊ: 2 ��Ա�� �Ӻ��� �볡! �õ���˫ɫ���Ʊ������: [17, 24, 29, 30, 31, 32, 07]
	// ���Ϊ: 1 ��Ա�� �Ӻ��� �볡! �õ���˫ɫ���Ʊ������: [06, 11, 14, 22, 29, 32, 15]
	// //.....
	// �Ӻ����볡��Ա���ܹ�: 13 λԱ��
	// ��ǰ���볡��Ա���ܹ�: 87 λԱ��
	public static void main(String[] args) {
		new nianhui("aaa").start();
		new nianhui("bbb").start();
	}
}

class nianhui extends Thread {
	private static int person = 1;
	private int qian = 0;
	private int hou = 0;

	public nianhui(String name) {
		super(name);

	}

	public void run() {
		while (true) {
			synchronized (nianhui.class) {
				String name = getName();
				if (person >=100) {
					if ("bbb".equals(name)) {
					System.out.println("�Ӻ����볡��Ա���ܹ�: " + hou + " λԱ��");
					 }
					 if ("aaa".equals(name)) {
					System.out.println("��ǰ���볡��Ա���ܹ�: " + qian + " λԱ��");
					 }
					break;
				}
				if ("bbb".equals(name)) {
					hou++;
				} 
				if ("aaa".equals(name)) {
					qian++;
				} 
				System.out.println("���Ϊ:" + person + "��Ա�� ��" + getName()+ "�볡!");
				person++;

			}
		}
	}
}