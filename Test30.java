package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Test30 {
	// ��һ������ String arr[]={"abc","bad","abc","aab","bad","cef","jhi"};
	// a. ����һ��ArrayList�������������Ԫ����ӽ�ȥ����Ԫ�ز����ظ� (�����鲻��)
	// b. ����һ�� TreeSet�������������Ԫ�ذ����������ü�������Ҳ���ȥ��
	// c. ���������������Ԫ�ش��뵽��Ŀ��Ŀ¼�µ�String.txt�ļ���

	public static void main(String[] args) throws Exception {
		// ��������
		String arr[] = { "abc", "bad", "abc", "aab", "bad", "cef", "jhi" };
		// a.����һ��ArrayList�������������Ԫ����ӽ�ȥ����Ԫ�ز����ظ� (�����鲻��)
		ArrayList<String> list = new ArrayList<>();
		for (String str : arr) {
			if (!list.contains(str))
				list.add(str);
		}
		System.out.println(list);
		// b.����һ�� TreeSet�������������Ԫ�ذ����������ü�������Ҳ���ȥ��
		// ����TreeSet���ϣ�������һ���Ƚ���
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int num = s1.compareTo(s2);
				return num == 0 ? 1 : num;
			}

		});
		// ��������arr,��Ԫ����ӵ�ts������
		for (String str : arr) {
			ts.add(str);
		}
		System.out.println(ts);
		// c.���������������Ԫ�ش��뵽��Ŀ��Ŀ¼�µ�String.txt�ļ���
		BufferedWriter bw = new BufferedWriter(new FileWriter("String.txt"));
		for (String str : arr) {
			bw.write(str);
			bw.newLine();
		}
		bw.close();
		// a,b,c,d,e 3 abc dec
		FileReader fr = new FileReader("String.txt");
		char[] chars = new char[1024 * 8];
		int len = -1;
		while (-1 != (len = fr.read(chars))) {
			System.out.println(new String(chars, 0, len));
		}
	}
}
