package com.nanjing.three;

public class Test13 {
	// 有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出，利用多线程模拟该过程并将线程的名称打印出来.

	public static void main(String[] args) {
		LiPin lv = new LiPin();
		new Thread(lv, "张玮真帅").start();
		new Thread(lv, "张玮非常帅").start();

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
				System.out.println(Thread.currentThread().getName() + "发第 "
						+ num + " 份礼品！");
				num--;
			}
		}
	}

}
