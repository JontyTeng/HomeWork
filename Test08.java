package com.nanjing.three;

public class Test08 {
		/*写一个卖票的程序,
	     1.写一个类,该类实现了Runnable接口.有一个私有类型的int作为参数tickets.
		   票的总数为100,完成run方法,输出结果的格式如下:
		   当前窗口为:窗口a,剩余票数为19,其中窗口a为线程的名字
		 2.开启四个卖票窗口(开始四个线程),同时执行卖票的程序*/
		public static void main(String[] args) {
			//1.创建Runnable接口的实现类对象
			Tickets t = new Tickets();
			//2.开启4个线程
			new Thread(t, "窗口a").start();
			new Thread(t, "窗口b").start();
			new Thread(t, "窗口c").start();
			new Thread(t, "窗口d").start();
		}
	}
class Tickets implements Runnable {
	private int tickets = 100;
	@Override
	public void run() {
		while(true) {
			synchronized (Tickets.class) {
				//首先判断是否有票，没有直接跳出循环
				if(tickets<=0)
					break;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//a,b,c,d
				System.out.println(Thread.currentThread().getName()+",剩余票数为"+(--tickets));
			}
		}
	}	
}