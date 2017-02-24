package com.nanjing.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Test27 {
	// һֱ����int arr[] = {2,3,4,2,4}; (10��)
	// (1)������������ƽ���֡����ֵ����Сֵ
	// (2)��������ƽ���ֵ�Ԫ�طŵ���ǰ��Ŀ¼��number.txt��(��׷�ӵķ�ʽ���)

	public static void main(String[] args) throws Exception {
		// ��������
		int arr[] = { 2, 3, 4, 2, 4 };
		// (1)������������ƽ���֡����ֵ����Сֵ
		int sum = 0;
		int max = arr[0];// �����0��Ԫ��������
		int min = arr[0];// �����0��Ԫ������С��
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		// ����ƽ����
		double avg = sum * 1.0 / arr.length;
		System.out
				.println("�������ƽ����:" + avg + " , ���ֵ:" + max + " , ��Сֵ:" + min);
		// �������е�Ԫ�ش���avg��д�뵽�ļ���
		writeArr2File(arr, avg);
		readFromFile();
	}

	// �������е�Ԫ�ش���avg��д�뵽�ļ���
	private static void writeArr2File(int[] arr, double avg) throws Exception {
		/*
		 * //1.���������ֽ���������� DataOutputStream dos = new DataOutputStream(new
		 * FileOutputStream("number.txt",true)); //2.��������,������������Ԫ��д�뵽�ļ��� for
		 * (int i : arr) { if(i>avg) { dos.writeInt(i); } } //3.�ر��� dos.close();
		 */

		BufferedWriter bw = new BufferedWriter(new FileWriter("number.txt",
				true));
		for (int i : arr) {
			if (i > avg) {
				bw.write(i + "");
				bw.newLine();
			}
		}
		bw.close();

	}

	private static void readFromFile() throws Exception {
		/*
		 * //1.���������ֽ����������� DataInputStream dis = new DataInputStream(new
		 * FileInputStream("number.txt")); int i = dis.readInt();
		 * System.out.println(i+" "); i = dis.readInt();
		 * System.out.println(i+" ");
		 */
		BufferedReader br = new BufferedReader(new FileReader("number.txt"));
		String line = null;
		while (null != (line = br.readLine())) {
			System.out.println(line);
		}
		br.close();
	}
}
