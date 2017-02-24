package com.nanjing.three;

import java.util.Comparator;
import java.util.TreeSet;

public class Test24 {
	// ����һ��ʵ������������ѧ�š��ɼ�(int����)��������
	// (1)�ڴ�������ʱ����Щ���Խ�����ʾ��ʼ��
	// (2)��ѧ������Ϣ(������ѧ�š��ɼ�)���뵽�ʵ��ļ��ϣ����Ҹ���ѧ�����䰴�ս����ӡ������̨

	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
			@Override
			public int compare(Student stu1, Student stu2) {
				// TODO Auto-generated method stub
				return stu1.getScore() - stu2.getScore();
			}
		});
		ts.add(new Student("����", "001", 90));
		ts.add(new Student("����", "002", 100));
		ts.add(new Student("����", "003", 80));
		ts.add(new Student("����", "004", 60));
		System.out.println(ts);
	}
}

class Student implements Comparable<Student> {
	private String name;
	private String ID;
	private int score;

	public Student() {
	}

	public Student(String name, String iD, int score) {
		super();
		this.name = name;
		ID = iD;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ID=" + ID + ", score=" + score
				+ "]";
	}

	@Override
	public int compareTo(Student o) {

		return o.score - this.score;
	}

}
