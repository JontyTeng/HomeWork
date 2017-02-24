package com.nanjing.three;

import java.util.ArrayList;
import java.util.Collections;

public class Test333 {
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
		
		MyThread10 my1 = new MyThread10("抽奖箱1");
		MyThread10 my2 = new MyThread10("抽奖箱2");
		my1.start();
		my2.start();
		
	}
}
class MyThread10 extends Thread{
	public static int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
	public static ArrayList<Integer> al = new ArrayList<>();
	static {
		for (Integer i : arr) {
			al.add(i);
		}
	}
	public MyThread10(String string) {
		super(string);
	}
	@Override
	public void run() {
		while(true){
			synchronized (MyThread10.class) {
				if(al.size() == 0){
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName()+" 又产生了一个"+getNum()+"大奖");
			}
		}
		
		
	}
	private int getNum() {
		Collections.shuffle(al);
		Integer integer = al.get(0);
		al.remove(0);
		return integer;
	}
}