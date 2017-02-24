package com.nanjing.three;

public class Test25 {
	// 同时开启两个线程，共同输出1-100之间的所有数字，并且将输出奇数的线程名称打印出来

	public static void main(String[] args) {
		PrintNumber pn = new PrintNumber();
		new Thread(pn, "线程a").start();
		new Thread(pn, "线程b").start();
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
							+ "输出了: " + num);
				}
				num++;
			}
		}

	}

}
