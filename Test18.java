package com.nanjing.three;

public class Test18 {
	// ��100���������ˮ��������ֻ��ͨ��ʵ���͹������ܽ��й��򣬲��ҷֱ�ͳ�����˶��١������߳̽���ģ�Ⲣ�����߳��������������۳�;�����ٽ���Ϣ��ӡ������
	// ���磨ʵ���������1�����ܹ�ʣ��n��..��

	public static void main(String[] args) {
		Cup cup = new Cup();
		new Thread(cup, "ʵ���").start();
		new Thread(cup, "����").start();
	}
}

class Cup implements Runnable {
	private int num = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (num <= 0)
					break;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "������"
						+ (100 - num + 1) + "�����ܹ�ʣ�� " + (--num) + " ��..");
			}
		}

	}

}
