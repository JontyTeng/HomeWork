package com.nanjing.three;

public class Test16 {
	// һ����1000�ŵ�ӰƱ,����������������ȡ,����ÿ����ȡ��ʱ��Ϊ3000����,
	// Ҫ��:���ö��߳�ģ����Ʊ���̲���ӡʣ���ӰƱ������
	public static void main(String[] args) {
		Ticket t = new Ticket();
		new Thread(t, "����a").start();
		new Thread(t, "����b").start();

	}
}

class Ticket implements Runnable {
	private int tickets = 200;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (tickets <= 0)
					break;
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "���� "
						+ (tickets--) + " ��Ʊ");
			}
		}

	}

}
