package com.qf.test;

import java.awt.im.InputSubset;
import java.util.List;

import com.qf.entity.Student;
import com.qf.istutinterface.IStudentInterface;
import com.qf.stutype.StuType;
import com.qf.sysmanage.SysManage;

/**
 * ���� ���һ��ѧԱ����Ϣ��  ���������䡢ѧ�š����
 * ������ ѧԱ����Ĳ����� ��ӡ�ɾ�������ҡ��滻
 *
 */
public class Test {
	public static void main(String[] args) {
		IStudentInterface manage = new SysManage();
		manage.add(new Student("zs", "18", "1001", "1803"));
		manage.add(new Student("ls", "19", "1003", "1803"));
		manage.add(new Student("ww", "21", "1004", "1803"));
		manage.add(new Student("zs", "21", "1006", "1803"));
		manage.add(new Student("ww", "22", "1005", "1803"));
		
		List<Student> list = manage.queryAll();  //��ѯ����
		for(Student st: list){
			System.out.println(st);
		}
		
		
		//���ĳ����������
		List<Student> list2 = manage.queryForType(StuType.ST_NAME, "zs");
		
		System.out.println("-----------���ݾ������Բ���ѧ������-------");
		for(Student st: list2){
			System.out.println(st);
		}
		
		manage.deleteStudent("1803", "1001");
		
		
		manage.updateStudent("1803", "1003", StuType.ST_AGE, "22");
		System.out.println("---------�޸�ѧ����-----------");
		List<Student> list3 = manage.queryAll();
		for(Student st: list3){
			System.out.println(st);
		}
	}
}
