package com.nanjing.three;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Test10 {
	// ���û��ڿ���̨�������5�����ְ��մ�С˳����뵽D:\\xx.txt��,��������ʾ�ڿ���̨��
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		System.out.println("������5��int���͵����ݣ�");
		for (int i = 0; i < arr.length; ) {
			try {
				arr[i] = Integer.parseInt(sc.nextLine());
				i++;//�ɹ�����һ�β�++
			} catch (Exception e) {
				System.out.println("����");
				continue;
			}
		}
		// ����Arrays.sort(int[]):������Ԫ�ؽ��������Ǵ�С�����˳��
		Arrays.sort(arr);
		// ��Ϊ������Ǵ�С��������Ҫ��Ӵ��С��˳��д�뵽�ļ��Ļ���ֻ��Ҫ���ű���
		// ���������ֽ����������
		FileWriter fw = new FileWriter("D:\\xx.txt");
		for (int i = arr.length - 1; i >= 0; i--) {
			fw.write(arr[i] + " ");
		}
		fw.close();
		BufferedReader br = new BufferedReader(new FileReader("D:\\xx.txt"));
		String line = br.readLine();
		System.out.println(line);
		br.close();
	}
}
