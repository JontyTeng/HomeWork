package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test19 {
	// ��һ��Map��������洢����ѧ�������������䣬��������{������=21, ���ʦ̫=38, ����=28, ���»�=40, �Ϲ�=36,
	// ��������=38}
	// a.�������Ԫ�������ֱ�����ʽ��ӡ������̨��
	// b.���Ϲ������ĳ�66
	// c.���������24��ѧ�����������뵽D:\\student.txt��

	public static void main(String[] args) throws Exception {
		// ����һ��TreeMap����,����������
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("������", 21);
		tm.put("���ʦ̫", 38);
		tm.put("����", 28);
		tm.put("���»�", 40);
		tm.put("�Ϲ�", 36);
		tm.put("��������", 38);
		// �������Ԫ�������ֱ�����ʽ��ӡ������̨��
		// ���õ�������ȡ���е�key,ͨ������key,��ȡ��Ӧ��value
		Set<String> set = tm.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = tm.get(key);
			System.out.println(key + "=" + value);
		}
		System.out.println("---------------");
		Set<Map.Entry<String, Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<String, Integer>> it2 = entrySet.iterator();
		while (it2.hasNext()) {
			Map.Entry<String, Integer> entry = it2.next();
			/*
			 * if("�Ϲ�".equals(entry.getKey())) { entry.setValue(88); }
			 */
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
		System.out.println("===================");
		// b.���Ϲ������ĳ�66
		tm.put("�Ϲ�", 66);
		System.out.println(tm);
		// c.���������24��ѧ�����������뵽D:\\student.txt��
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("D:\\student.txt"));
		for (Map.Entry<String, Integer> entry : tm.entrySet()) {
			if (entry.getValue() > 24) {
				// ����Ӧ��ѧ������д�뵽�ļ�
				bw.write(entry.getKey());
				bw.newLine();
			}
		}
		bw.close();
		

	}
}
