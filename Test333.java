package com.nanjing.three;

import java.util.ArrayList;
import java.util.Collections;

public class Test333 {
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
		
		MyThread10 my1 = new MyThread10("�齱��1");
		MyThread10 my2 = new MyThread10("�齱��2");
		my1.start();
		my2.start();
		
	}
}
class MyThread10 extends Thread{
	public static int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
	public static ArrayList<Integer> al = new ArrayList<>();
	static {
		for (Integer i : arr) {
			al.add(i);
		}
	}
	public MyThread10(String string) {
		super(string);
	}
	@Override
	public void run() {
		while(true){
			synchronized (MyThread10.class) {
				if(al.size() == 0){
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName()+" �ֲ�����һ��"+getNum()+"��");
			}
		}
		
		
	}
	private int getNum() {
		Collections.shuffle(al);
		Integer integer = al.get(0);
		al.remove(0);
		return integer;
	}
}