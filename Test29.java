package com.nanjing.three;

import java.util.Arrays;
import java.util.Random;

public class Test29 {
	// .ĳ��˾��֯���,�����볡ʱ���������,���볡ʱÿλԱ�����ܻ�ȡһ��˫ɫ���Ʊ,���蹫˾��100��Ա��,���ö�
	//
	// �߳�ģ������볡����,
	// ���ֱ�ͳ��ÿ������볡������,�Լ�ÿ��Ա���õ��Ĳ�Ʊ�ĺ��롣�߳����к��ӡ��ʽ���£�
	// ���Ϊ: 2 ��Ա�� �Ӻ��� �볡! �õ���˫ɫ���Ʊ������: [17, 24, 29, 30, 31, 32, 07]
	// ���Ϊ: 1 ��Ա�� �Ӻ��� �볡! �õ���˫ɫ���Ʊ������: [06, 11, 14, 22, 29, 32, 15]
	// //.....
	// �Ӻ����볡��Ա���ܹ�: 13 λԱ��
	// ��ǰ���볡��Ա���ܹ�: 87 λԱ��

	public static void main(String[] args) {
		// ���Բ���˫ɫ��Ĵ���
		// String doubleColorBallNumber = DoubleColorBallUtil.create();
		// System.out.println(doubleColorBallNumber);
		// 1.����ʵ��Runnable�ӿڵ�ʵ�������
		NianHui2 nh = new NianHui2();
		// 2.�����̲߳�����
		new Thread(nh, "����").start();
		new Thread(nh, "ǰ��").start();
	}
}

/**
 * ��Ҫ�߳�ͬ�� 1.���̲߳����������� 2.�����������ݵ��������������
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
		// ��ȡ��ǰ�̵߳�����
		String threadName = Thread.currentThread().getName();
		while (true) {
			synchronized (this) {
				// num<=0,�߳���ֹ
				if (num <= 0) {
					if ("����".equals(threadName)) {
						System.out.println("��" + threadName + "�볡��Ա���ܹ�: "
								+ hmCount + " λԱ��");
					} else {
						System.out.println("��" + threadName + "�볡��Ա���ܹ�: "
								+ qmCount + " λԱ��");
					}
					break;
				}
				// ����˫ɫ��
				String doubleColorBallNumber = DoubleColorBallUtil.create();
				if ("����".equals(threadName)) {
					hmCount++;
				} else {
					qmCount++;
				}
				System.out.println("���Ϊ: " + (num--) + " ��Ա�� ��" + threadName
						+ " �볡! �õ���˫ɫ���Ʊ������: " + doubleColorBallNumber);
			}
		}
	}

}

class DoubleColorBallUtil {

	// ����˫ɫ��Ĵ���
	public static String create() {
		String[] red = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31", "32", "33" };
		/*
		 * //�������� for(int i=0;i<red.length;i++) { char[] ch = {'0','0'}; String
		 * s = Integer.toString(i+1);//"1" char[] num = s.toCharArray();//{'1'}
		 * System.arraycopy(num, 0, ch, ch.length-num.length, num.length);
		 * String ball = new String(ch); red[i] = ball; }
		 */

		// System.out.println(Arrays.toString(red));//��ӡ01-33
		// ��������
		String[] blue = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16"
				.split(",");
		boolean[] used = new boolean[red.length];
		Random r = new Random();
		String[] all = new String[7];
		for (int i = 0; i < 6; i++) {
			int idx;
			do {
				idx = r.nextInt(red.length);// 0-32
			} while (used[idx]);// ���ʹ���˼�������һ��
			used[idx] = true;// ���ʹ����
			all[i] = red[idx];// ȡ��һ��δʹ�õĺ���
		}
		all[all.length - 1] = "99";
		// System.out.println(Arrays.toString(all));
		Arrays.sort(all);
		all[all.length - 1] = blue[r.nextInt(blue.length)];
		return Arrays.toString(all);
	}
}