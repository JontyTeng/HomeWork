package com.nanjing.three;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test05 {
	// ��list�����������{����,����,����,��Ѿ,Ǯ��,����},����Ѿ�滻Ϊ��СѾ

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		// 1.����List���϶���
		List<String> list = new ArrayList<>();
		// 2.��������
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("��Ѿ");
		list.add("Ǯ��");
		list.add("����");
		// ������ͨforѭ������List����
		for (int i = 0; i < list.size(); i++) {
			// ��ȡ��ǰԪ��
			String thisName = list.get(i);
			// �����ǰԪ����"��Ѿ"
			if ("��Ѿ".equals(thisName)) {
				// �����Ϊ"��СѾ"
				list.set(i, "��СѾ");
			}
		}
		System.out.println(list);
	}
}
