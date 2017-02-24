package com.nanjing.three;

import java.util.ArrayList;
import java.util.Random;

public class Test33 {
	// ��һ���齱��,�ó齱���д���˽����Ľ��,�ó齱����һ������int[] arr =
	//
	// {10,5,20,50,100,200,500,800,2,80,300};
	// ���������齱��(�߳�)�����߳����Ʒֱ�Ϊ���齱��1�������齱��2���������arr�����л�ȡ����Ԫ�ز���
	//
	// ӡ�ڿ���̨��,��ʽ����:
	//
	// �齱��1 �ֲ�����һ�� 10 Ԫ��
	// �齱��2 �ֲ�����һ�� 100 Ԫ��

	public static void main(String[] args) {
		// ����ʵ��Runnable�ӿڵ�ʵ�������
		ChouJiang cj = new ChouJiang();
		// ���������̲߳�����
		new Thread(cj, "�齱��1").start();
		new Thread(cj, "�齱��2").start();
	}
}

class ChouJiang implements Runnable {
	private int[] arr = { 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300 };
	private int num = arr.length;
	private ArrayList<Integer> list = new ArrayList<Integer>();

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		while (true) {
			synchronized (ChouJiang.class) {
				if (num <= 0){
					break;
				}
				// �������������
				Random r = new Random();
				int index;
				// Ϊ�˻�ȡ���ظ�������ֵ
				while (true) {
					index = r.nextInt(arr.length);
					if (list.contains(index))
						continue;
					else {
						list.add(index);
						break;
					}
				}
				int money = arr[index];
				System.out.println(threadName + " �ֲ�����һ�� " + money + " Ԫ��");
				num--;
			}
		}

	}

}