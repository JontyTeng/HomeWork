package com.nanjing.three;

import java.util.HashMap;
import java.util.Map;

public class Test11 {

	// 2.������һ��map��������:
	// {1="������",2="������",3="����",4="���ʦ̫"}
	// Ҫ��:
	// 1.��map�����е�������Ϣ��ʾ������̨��
	// 2.���map�����в���һ������Ϊ5����Ϊ���������Ϣ
	// 3.�Ƴ���map�еı��Ϊ1����Ϣ
	// 4.��map�����б��Ϊ2��������Ϣ�޸�Ϊ"����"

	public static void main(String[] args) {
		// ����map���ϣ����洢����
		HashMap<Integer, String> hs = new HashMap<Integer, String>();
		hs.put(1, "������");
		hs.put(2, "������");
		hs.put(3, "����");
		hs.put(4, "���ʦ̫");
		// 1.��map�����е�������Ϣ��ʾ������̨��
		for (Map.Entry<Integer, String> entry : hs.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		System.out.println("----------------");
		// 2.���map�����в���һ������Ϊ5����Ϊ���������Ϣ
		hs.put(5, "������");
		System.out.println(hs);
		// 3.�Ƴ���map�еı��Ϊ1����Ϣ
		hs.remove(1);
		System.out.println(hs);
		// 4.��map�����б��Ϊ2��������Ϣ�޸�Ϊ"����"
		// hs.put(2, "����");
		for (Map.Entry<Integer, String> entry : hs.entrySet()) {
			if (entry.getKey() == 2) {
				entry.setValue("����");
			}
		}
		System.out.println(hs);
	}
}
