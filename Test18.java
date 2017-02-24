package com.nanjing.three;

public class Test18 {
	// 有100个限量版的水杯，但是只能通过实体店和官网才能进行购买，并且分别统计卖了多少。请用线程进行模拟并设置线程名称用来代表售出途径，再将信息打印出来。
	// 比如（实体店卖出第1个，总共剩余n个..）

	public static void main(String[] args) {
		Cup cup = new Cup();
		new Thread(cup, "实体店").start();
		new Thread(cup, "官网").start();
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
				System.out.println(Thread.currentThread().getName() + "卖出第"
						+ (100 - num + 1) + "个，总共剩余 " + (--num) + " 个..");
			}
		}

	}

}
