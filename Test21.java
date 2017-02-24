package com.nanjing.three;

public class Test21 {
	// 有一辆班车除司机外只能承载80个人，假设前中后三个车门都能上车，如果坐满则不能再上车。请用线程模拟上车
	//
	// 过程并且在控制台打印出是从哪个车门上车以及剩下的座位数。比如:
	// （前门上车---还剩N个座...）
	public static void main(String[] args) {
		Car car = new Car();
		new Thread(car, "前门").start();
		new Thread(car, "中门").start();
		new Thread(car, "后门").start();
	}
}

class Car implements Runnable {
	private int seats = 80;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (seats <= 0)
					break;
				System.out.println(Thread.currentThread().getName() + "上车---还剩"
						+ (--seats) + "个座...");
			}
		}
	}
}
