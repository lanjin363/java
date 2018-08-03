package com.qf.istutinterface;

import java.util.List;

import com.qf.entity.Student;

public interface IStudentInterface {
	//添加学生对象
	public boolean add(Student st);
	//查询所有
	public List<Student> queryAll();
	//参数1： 查找的类型   参数2： 查找的具体值           
	public List<Student> queryForType(int type,String string);
	//根据班号、学号删除一个学生对象
	public boolean deleteStudent(String classNum,String num);
	//参数1:要修改的班号  参数2： 要修改的学号  参数3： 匹配要修改的类型  参数4： 修改成的值
	public boolean updateStudent(String classNum,String num,int type,String string);
}
