package com.qf.e_pare2;

import java.util.Comparator;

public class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		//�������С��������
		//��һ������o1��Ҫ�洢�Ķ���Ԫ��,�ڶ�������o2ΪҪ�ȽϵĶ���Ԫ��
		return o1.getAge()-o2.getAge();
	}

}
