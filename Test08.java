package com.nanjing.three;

public class Test08 {
		/*дһ����Ʊ�ĳ���,
	     1.дһ����,����ʵ����Runnable�ӿ�.��һ��˽�����͵�int��Ϊ����tickets.
		   Ʊ������Ϊ100,���run����,�������ĸ�ʽ����:
		   ��ǰ����Ϊ:����a,ʣ��Ʊ��Ϊ19,���д���aΪ�̵߳�����
		 2.�����ĸ���Ʊ����(��ʼ�ĸ��߳�),ͬʱִ����Ʊ�ĳ���*/
		public static void main(String[] args) {
			//1.����Runnable�ӿڵ�ʵ�������
			Tickets t = new Tickets();
			//2.����4���߳�
			new Thread(t, "����a").start();
			new Thread(t, "����b").start();
			new Thread(t, "����c").start();
			new Thread(t, "����d").start();
		}
	}
class Tickets implements Runnable {
	private int tickets = 100;
	@Override
	public void run() {
		while(true) {
			synchronized (Tickets.class) {
				//�����ж��Ƿ���Ʊ��û��ֱ������ѭ��
				if(tickets<=0)
					break;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//a,b,c,d
				System.out.println(Thread.currentThread().getName()+",ʣ��Ʊ��Ϊ"+(--tickets));
			}
		}
	}	
}