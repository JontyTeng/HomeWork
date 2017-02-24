package com.nanjing.three;

import java.util.Comparator;
import java.util.TreeSet;

public class Test24 {
	// 定义一个实体类有姓名、学号、成绩(int类型)三个属性
	// (1)在创建对象时给这些属性进行显示初始化
	// (2)将学生的信息(姓名、学号、成绩)存入到适当的集合，并且根据学生年龄按照降序打印到控制台

	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
			@Override
			public int compare(Student stu1, Student stu2) {
				// TODO Auto-generated method stub
				return stu1.getScore() - stu2.getScore();
			}
		});
		ts.add(new Student("张三", "001", 90));
		ts.add(new Student("李四", "002", 100));
		ts.add(new Student("王五", "003", 80));
		ts.add(new Student("赵六", "004", 60));
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
