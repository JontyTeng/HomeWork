package com.nanjing.three;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test06 {
	// �Ӽ�������һ��ֵ,����ֵ�����ж������С��60�����sorry,����ǰ���60�����������ok

	public static void main(String[] args) throws Exception {
		// ��������¼�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ��ȡ�û�����������ַ���
		String line = br.readLine();
		// ���ַ���ת����int���͵�����
		int number;
		try {
			number = Integer.parseInt(line);
			if (number < 60) {
				System.out.println("sorry");
			} else {
				System.out.println("ok");
			}
		} catch (Exception e) {
			System.out.println("��������");
		}
		
	}
}
