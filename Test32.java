package com.nanjing.three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Test32 {
	/*
	 * �ڵ�ǰ��Ŀ��Ŀ¼����һ����qq.txt�ļ��������ŵ��������£���14�֣� ����Ŀ��Ŀ¼,����qq�ŵĳ������Ϊ11λ�� 12345 67891
	 * 12347809933 98765432102 67891 12347809933 a.�����ļ����������qq�Ŷ������list��
	 * b.��list���ظ�Ԫ��ɾ�� c.��ʣ��Ԫ�ؽ�������(���ճ�����С����) d.��list������Ԫ�������ַ�ʽ��ӡ����
	 */

	public static void main(String[] args) throws Exception {
		// a.�����ļ����������qq�Ŷ������list��
		// �����ַ�����������
		BufferedReader br = new BufferedReader(new FileReader("qq.txt"));
		String line = null;
		// �������϶���,�洢QQ��
		ArrayList<String> list = new ArrayList<String>();
		while (null != (line = br.readLine())) {
			list.add(line);
		}
		// �ر�������
		br.close();
		System.out.println(list);
		// b.��list���ظ�Ԫ��ɾ��
		// ����LinkedHashSet������,�������ȥ��,������ô�������ôȡ��
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		for (String str : list) {
			lhs.add(str);
		}
		// ���list����
		list.clear();
		// ��lhs�����е�Ԫ����ӵ�list��
		list.addAll(lhs);
		System.out.println(list);
		// c.��ʣ��Ԫ�ؽ�������(���ճ�����С����)
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int num = s1.length() - s2.length();
				return num == 0 ? 1 : num;
			}

		});
		for (String str : list) {
			ts.add(str);
		}
		System.out.println(ts);

		// d.��list������Ԫ�������ַ�ʽ��ӡ����
		// 1.���ø߼�forѭ��
		for (int i = 0; i < list.size(); i++) {
			String qq = list.get(i);
			if (i == list.size() - 1) {
				System.out.println(qq);

			} else {
				System.out.print(qq + ", ");
			}
		}
		System.out.println();
		// 2.���õ�����
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
