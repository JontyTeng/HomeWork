package com.nanjing.three;

public class Test16 {
	// 一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
	// 要求:请用多线程模拟领票过程并打印剩余电影票的数量
	public static void main(String[] args) {
		Ticket t = new Ticket();
		new Thread(t, "窗口a").start();
		new Thread(t, "窗口b").start();

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
				System.out.println(Thread.currentThread().getName() + "卖第 "
						+ (tickets--) + " 张票");
			}
		}

	}

}
