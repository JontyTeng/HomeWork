package com.nanjing.three;

import java.util.Arrays;
import java.util.Random;

public class Test29 {
	// .某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票,假设公司有100个员工,利用多
	//
	// 线程模拟年会入场过程,
	// 并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印格式如下：
	// 编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是: [17, 24, 29, 30, 31, 32, 07]
	// 编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: [06, 11, 14, 22, 29, 32, 15]
	// //.....
	// 从后门入场的员工总共: 13 位员工
	// 从前门入场的员工总共: 87 位员工

	public static void main(String[] args) {
		// 测试产生双色球的代码
		// String doubleColorBallNumber = DoubleColorBallUtil.create();
		// System.out.println(doubleColorBallNumber);
		// 1.创建实现Runnable接口的实现类对象
		NianHui2 nh = new NianHui2();
		// 2.创建线程并启动
		new Thread(nh, "后门").start();
		new Thread(nh, "前门").start();
	}
}

/**
 * 需要线程同步 1.多线程操作共享数据 2.操作共享数据的语句有两条以上
 * 
 * @author JX
 * 
 */
class NianHui2 implements Runnable {
	private int num = 100;
	private int hmCount = 0;
	private int qmCount = 0;

	@Override
	public void run() {
		// 获取当前线程的名称
		String threadName = Thread.currentThread().getName();
		while (true) {
			synchronized (this) {
				// num<=0,线程终止
				if (num <= 0) {
					if ("后门".equals(threadName)) {
						System.out.println("从" + threadName + "入场的员工总共: "
								+ hmCount + " 位员工");
					} else {
						System.out.println("从" + threadName + "入场的员工总共: "
								+ qmCount + " 位员工");
					}
					break;
				}
				// 产生双色球
				String doubleColorBallNumber = DoubleColorBallUtil.create();
				if ("后门".equals(threadName)) {
					hmCount++;
				} else {
					qmCount++;
				}
				System.out.println("编号为: " + (num--) + " 的员工 从" + threadName
						+ " 入场! 拿到的双色球彩票号码是: " + doubleColorBallNumber);
			}
		}
	}

}

class DoubleColorBallUtil {

	// 产生双色球的代码
	public static String create() {
		String[] red = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31", "32", "33" };
		/*
		 * //创建红球 for(int i=0;i<red.length;i++) { char[] ch = {'0','0'}; String
		 * s = Integer.toString(i+1);//"1" char[] num = s.toCharArray();//{'1'}
		 * System.arraycopy(num, 0, ch, ch.length-num.length, num.length);
		 * String ball = new String(ch); red[i] = ball; }
		 */

		// System.out.println(Arrays.toString(red));//打印01-33
		// 创建蓝球
		String[] blue = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16"
				.split(",");
		boolean[] used = new boolean[red.length];
		Random r = new Random();
		String[] all = new String[7];
		for (int i = 0; i < 6; i++) {
			int idx;
			do {
				idx = r.nextInt(red.length);// 0-32
			} while (used[idx]);// 如果使用了继续找下一个
			used[idx] = true;// 标记使用了
			all[i] = red[idx];// 取出一个未使用的红球
		}
		all[all.length - 1] = "99";
		// System.out.println(Arrays.toString(all));
		Arrays.sort(all);
		all[all.length - 1] = blue[r.nextInt(blue.length)];
		return Arrays.toString(all);
	}
}