package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) throws IOException {
		// 1.����10��1-20�������,�������д��ڵ���10�����ַŵ�һ��list�����У�����ӡ������̨��
		// (1)���峤��Ϊ10��int����
		int[] arr = new int[10];
		// (2)��������������Ķ���
		Random r = new Random();
		// (3)���������,������������
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(20) + 1;
		}
		System.out.println("�������������:" + Arrays.toString(arr));
		// (4)�������д��ڵ���10�����ַŵ�һ��list�����У�����ӡ������̨��
		// ����List����
		ArrayList<Integer> list = new ArrayList<>();
		// ����arr����,��>=10��Ԫ�ش��뵽list������
		for (Integer thisNum : arr) {
			if (thisNum >= 10)
				list.add(thisNum);
		}
		System.out.println(list);
		// 2.��������С��10�����ַŵ�һ��list�����У�����ӡ������̨��
		//���������Ҫ�ŵ�map�����У�Ҳ���԰������е�����������Ԫ����ֵ
		//��Ϊ����������ǲ����ظ��ġ�
		ArrayList<Integer> list2 = new ArrayList<>();
		// ����arr����,��>=10��Ԫ�ش��뵽list������
		for (Integer thisNum : arr) {
			if (thisNum < 10)
				list2.add(thisNum);
		}
		System.out.println(list2);
		HashMap<Integer,Integer> hm = new HashMap<>();
		// ����arr����,��>=10��Ԫ�ش��뵽list������
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < 10){
				hm.put(i, arr[i]);
			}
		}
		System.out.println(hm);
	}
}
