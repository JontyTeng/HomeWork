package com.nanjing.three;

public class Test13 {
	// ��100����Ʒ,����ͬʱ���ͣ���ʣ�µ���ƷС��10�ݵ�ʱ�������ͳ������ö��߳�ģ��ù��̲����̵߳����ƴ�ӡ����.

	public static void main(String[] args) {
		LiPin lv = new LiPin();
		new Thread(lv, "������˧").start();
		new Thread(lv, "����ǳ�˧").start();

	}
}

class LiPin implements Runnable {
	private int num = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (num < 10)
					break;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "���� "
						+ num + " ����Ʒ��");
				num--;
			}
		}
	}

}
