package com.nanjing.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test28 {
	// ���һ��interface MyUtil���ýӿ����������󷽷�
	// ����һ����ʵ��MyUtil�ӿڲ�������Ҫ��ʵ���������󷽷�
	// public abstract void sort(ArrayList<Integer> list);
	// public abstract void filterChars(ArrayList<String> list);
	// a.ArrayList�������򷽷����������ArrayList����Ԫ�ؽ��н������򣨲���ֱ����Collections.sort()��
	//
	// ����
	// b.�ַ���������ĸ���������ArrayList<String>�����е�ÿ��Ԫ���е���ĸ���˵�,���磨����
	//
	// hello123java������123��

	public static void main(String[] args) {
		// ���������
		int[] arr = { 5, 4, 3, 2, 1 };
		/*
		 * //ð������ for(int i = 0;i<arr.length-1;i++) { for(int j =
		 * 0;j<arr.length-1-i;j++) {//j+1<arr.length if(arr[j]>arr[j+1]) { int
		 * temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp; } } }
		 */
		// ѡ������,5,4,3,2,1
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		MyUtil mu = new MyUtilImpl();
		mu.sort(list);
		System.out.println(list);

		ArrayList<String> strList = new ArrayList<String>();
		strList.add("a123bcd");
		strList.add("a3bcd");
		strList.add("e23bcd");
		strList.add("j09~!ubcd56");
		mu.filterChars(strList);
		System.out.println(strList);

	}
}

// ����ӿ�
interface MyUtil {
	public abstract void sort(ArrayList<Integer> list);

	public abstract void filterChars(ArrayList<String> list);
}

class MyUtilImpl implements MyUtil {

	// �������ArrayList����Ԫ�ؽ��н�������
	@Override
	public void sort(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int temp1 = list.get(i);
				int temp2 = list.get(j);
				if (temp1 > temp2) {
					list.set(i, temp2);
					list.set(j, temp1);
				}
			}
		}
	}

	// �ַ���������ĸ���������ArrayList<String>�����е�ÿ��Ԫ���е���ĸ���˵�,���磨���� hello123java������123��
	@Override
	public void filterChars(ArrayList<String> list) {
		// �ȶ���һ���¼���
		ArrayList<String> newList = new ArrayList<>();
		// 1.��������,�õ�ÿ��Ԫ��
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String str = it.next();
			// str = str.replaceAll("\\D+", "");
			// System.out.println(str);
			// ���ַ�������ַ�����
			char[] arr = str.toCharArray();

			// ��������
			// �����ַ�����������������
			StringBuilder sb = new StringBuilder();
			for (char ch : arr) {
				if (ch >= '0' && ch <= '9') {
					sb.append(ch + "");
				}
			}
			// it.remove();
			newList.add(sb.toString());
		}
		// ���Դ�����е�����
		list.clear();
		// ���¼����е�������ӵ��ϼ�����
		list.addAll(newList);
	}
}
