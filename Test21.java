package com.nanjing.three;

public class Test21 {
	// ��һ���೵��˾����ֻ�ܳ���80���ˣ�����ǰ�к��������Ŷ����ϳ�����������������ϳ��������߳�ģ���ϳ�
	//
	// ���̲����ڿ���̨��ӡ���Ǵ��ĸ������ϳ��Լ�ʣ�µ���λ��������:
	// ��ǰ���ϳ�---��ʣN����...��
	public static void main(String[] args) {
		Car car = new Car();
		new Thread(car, "ǰ��").start();
		new Thread(car, "����").start();
		new Thread(car, "����").start();
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
				System.out.println(Thread.currentThread().getName() + "�ϳ�---��ʣ"
						+ (--seats) + "����...");
			}
		}
	}
}
