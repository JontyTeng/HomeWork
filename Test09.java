package com.nanjing.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test09 {
	/*
	 * ����һ��list����:{"�Ű�֥","���»�","����","����ӱ","��ӱ","������"}
	 * 1.��дһ������:��list�������������ŵ���Աд�뵽D:\\a.txt��
	 * 2.��дһ������:��D:\\a.txt���������ŵ���Ա��Ϣ��ȡ��������ӡ������̨��
	 */
	// ����list����
	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<>();
		// ��������
		list.add("�Ű�֥");
		list.add("���»�");
		list.add("����");
		list.add("����ӱ");
		list.add("��ӱ");
		list.add("������");
		// ����list���ϣ�����������������д�뵽�ļ���
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\a.txt"));
		for (String thisName : list) {
			if (thisName.startsWith("��")) {
				bw.write(thisName);
				bw.newLine();
			}
		}
		bw.close();
		// ���ļ���ȡ����
		BufferedReader br = new BufferedReader(new FileReader("D:\\a.txt"));
		String line = null;
		while (null != (line = br.readLine())) {
			System.out.println(line);
		}
		br.close();
	}
}
