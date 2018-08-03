package com.qf.entity;

public class Student {
	private String name;
	private String age;
	private String num;   //Ñ§ºÅ
	private String classNum;   //°àºÅ
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", num=" + num + ", classNum=" + classNum + "]";
	}
	public Student(){}
	public Student(String name, String age, String num, String classNum) {
		this.name = name;
		this.age = age;
		this.num = num;
		this.classNum = classNum;
	}
	
	
	
}
