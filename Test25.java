package com.nanjing.three;

public class Test25 {
	// ͬʱ���������̣߳���ͬ���1-100֮����������֣����ҽ�����������߳����ƴ�ӡ����

	public static void main(String[] args) {
		PrintNumber pn = new PrintNumber();
		new Thread(pn, "�߳�a").start();
		new Thread(pn, "�߳�b").start();
	}
}

class PrintNumber implements Runnable {
	private int num = 1;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (num > 100)
					break;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (num % 2 != 0) {
					System.out.println(Thread.currentThread().getName()
							+ "�����: " + num);
				}
				num++;
			}
		}

	}

}
