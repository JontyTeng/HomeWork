package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws IOException {
		/*
		 * 1.��������10�������ŵ������� a. ȥ���������д���10���� b. ���������е�����д�뵽�����ļ�number.txt��
		 */
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		int index = 0;
		while (index < 10) {
			if (sc.hasNextInt()) {
				arr[index] = sc.nextInt();
				index++;
			}else{
				sc.nextLine();
				System.out.println("�����");
			}
		}
		//ͳ��С�ڵ���10��
		//����Ҳ����ֱ���ڴ����ʱ����ж�
		int count = 0 ;
		for (int i : arr) {
			if(i<=10){
				count++;
			}
		}
		int [] arr2 = new int [count];
		count = 0;//�����������0
		for (int i : arr) {
			if(i<=10){
				arr2[count] = i;
				count++;
			}
		}
		System.out.println(Arrays.toString(arr2));
		BufferedWriter bw = new BufferedWriter(new FileWriter("number.txt"));
		bw.write(Arrays.toString(arr2));
		bw.close();
	}
}
