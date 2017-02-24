package com.nanjing.three;

import java.util.Arrays;
import java.util.Random;

public class qwdqwdqwd {
	// .某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票,假设公司有100个员工,利用多
	// 线程模拟年会入场过程,
	// 并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印格式如下：
	// 编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是: [17, 24, 29, 30, 31, 32, 07]
	// 编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: [06, 11, 14, 22, 29, 32, 15]
	// //.....
	// 从后门入场的员工总共: 13 位员工
	// 从前门入场的员工总共: 87 位员工
	public static void main(String[] args) {
		new nianhui("aaa").start();
		new nianhui("bbb").start();
	}
}

class nianhui extends Thread {
	private static int person = 1;
	private int qian = 0;
	private int hou = 0;

	public nianhui(String name) {
		super(name);

	}

	public void run() {
		while (true) {
			synchronized (nianhui.class) {
				String name = getName();
				if (person >=100) {
					if ("bbb".equals(name)) {
					System.out.println("从后门入场的员工总共: " + hou + " 位员工");
					 }
					 if ("aaa".equals(name)) {
					System.out.println("从前门入场的员工总共: " + qian + " 位员工");
					 }
					break;
				}
				if ("bbb".equals(name)) {
					hou++;
				} 
				if ("aaa".equals(name)) {
					qian++;
				} 
				System.out.println("编号为:" + person + "的员工 从" + getName()+ "入场!");
				person++;

			}
		}
	}
}