package com.nanjing.three;

import java.util.ArrayList;
import java.util.Random;

public class Test33 {
	// 有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr =
	//
	// {10,5,20,50,100,200,500,800,2,80,300};
	// 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打
	//
	// 印在控制台上,格式如下:
	//
	// 抽奖箱1 又产生了一个 10 元大奖
	// 抽奖箱2 又产生了一个 100 元大奖

	public static void main(String[] args) {
		// 创建实现Runnable接口的实现类对象
		ChouJiang cj = new ChouJiang();
		// 创建两个线程并开启
		new Thread(cj, "抽奖箱1").start();
		new Thread(cj, "抽奖箱2").start();
	}
}

class ChouJiang implements Runnable {
	private int[] arr = { 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300 };
	private int num = arr.length;
	private ArrayList<Integer> list = new ArrayList<Integer>();

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		while (true) {
			synchronized (ChouJiang.class) {
				if (num <= 0){
					break;
				}
				// 创建随机数对象
				Random r = new Random();
				int index;
				// 为了获取不重复的索引值
				while (true) {
					index = r.nextInt(arr.length);
					if (list.contains(index))
						continue;
					else {
						list.add(index);
						break;
					}
				}
				int money = arr[index];
				System.out.println(threadName + " 又产生了一个 " + money + " 元大奖");
				num--;
			}
		}

	}

}