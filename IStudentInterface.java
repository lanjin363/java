package com.qf.istutinterface;

import java.util.List;

import com.qf.entity.Student;

public interface IStudentInterface {
	//���ѧ������
	public boolean add(Student st);
	//��ѯ����
	public List<Student> queryAll();
	//����1�� ���ҵ�����   ����2�� ���ҵľ���ֵ           
	public List<Student> queryForType(int type,String string);
	//���ݰ�š�ѧ��ɾ��һ��ѧ������
	public boolean deleteStudent(String classNum,String num);
	//����1:Ҫ�޸ĵİ��  ����2�� Ҫ�޸ĵ�ѧ��  ����3�� ƥ��Ҫ�޸ĵ�����  ����4�� �޸ĳɵ�ֵ
	public boolean updateStudent(String classNum,String num,int type,String string);
}
