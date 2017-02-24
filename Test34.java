package com.nanjing.three;

public class Test34 {
	public static void main(String[] args) {
		final Demo d = new Demo();
		new Thread() {
			public void run() {
				try {
					d.print1();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();

		new Thread() {
			public void run() {
				try {
					d.print2();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
	}
}

class Demo {
	public static int[] arr = { 1, 2, 3, 4, 5 };
	public static int flag = 1;
	public static int index = 0;

	public void print1() throws Exception {
		while(true){
			synchronized (Demo.class) {
				if(index == arr.length){
					break;
				}else{
					if(flag != 1){
						Demo.class.wait();
					}else{
						System.out.println(Thread.currentThread().getName() + arr[index]);
						index ++;
						flag = 2;
						Demo.class.notifyAll();
					}
				}
			}
		}

	}

	public void print2() throws Exception {
		while(true){
			synchronized (Demo.class) {
				if(index == arr.length){
					break;
				}else{
					if(flag != 2){
						Demo.class.wait();
					}else{
						System.out.println(Thread.currentThread().getName() + arr[index]);
						index ++;
						flag = 1;
						Demo.class.notifyAll();
					}
				}
			}
		}

	}
}