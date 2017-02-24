package com.nanjing.three;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test17 {
	//�Ӽ��̽��ܶ��int�͵�����,ֱ���û�����end����
	// Ҫ��:�����е�����������д��D:\\number.txt��

	public static void main(String[] args) throws Exception {
		//1.����ArrayList����
		ArrayList<Integer> list = new ArrayList<Integer>();
		//2.�������¼�����
		Scanner sc = new Scanner(System.in);
		//3.ѭ��¼�����ݣ������end������¼��
		while(true) {
			String str = sc.nextLine();
			//�ж��Ƿ���"end"
			if("end".equals(str)) {
				break;
			}
			int thisNum;
			try {
				thisNum = Integer.parseInt(str);
				//��������ӵ�������
				list.add(thisNum);
			} catch (Exception e) {
				System.out.println("�����");
			}
			
		}
		//�ȷ�ת�����е�����
		Collections.reverse(list);
		//��list�����е�����д�뵽�ļ���
		write2File(list);
	}
	
	//��list�����е�����д�뵽�ļ���
	private static void write2File(ArrayList<Integer> list) throws Exception {
		FileWriter fw = new FileWriter("D:\\number.txt");
		for (Integer integer : list) {
			fw.write(integer + "");
		}
		fw.close();
	}
}